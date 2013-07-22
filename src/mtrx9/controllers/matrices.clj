(ns mtrx9.controllers.matrices
  (:use [compojure.core :only (defroutes GET POST)]
        [lamina.core :only (named-channel receive-all siphon enqueue)]
        [aleph.http :only (wrap-aleph-handler)]
        [aleph.formats :only (encode-json->string)])
  (:require [ring.util.response :as ring]
            [clj-time.core :as time]
            [mtrx9.views.matrices :as view]))

(def id-chars  "0123456789SLATF-")
(def id-length 42)
(def id-re     (re-pattern (str "[" id-chars "]{" id-length "}")))

(defn- rand-matrix-id []
  (clojure.string/join (repeatedly id-length #(rand-nth id-chars))))

(defn websocket-handler [channel request]
  (let [matrix-id (get-in request [:route-params :id])
        matrix-channel (named-channel matrix-id nil)]
    (siphon matrix-channel channel)))

(defn show [id]
  (view/show id))

(defn create []
  (ring/redirect (str "/matrices/" (rand-matrix-id))))

(defn update [id streams]
  (println (str "[" (str (time/now)) "] " id  " <- " streams))
  (enqueue (named-channel id nil) (encode-json->string {:streams streams}))
  {:status 204})

(defroutes routes
  (GET ["/matrices/:id/websocket" :id id-re] []
    (wrap-aleph-handler websocket-handler))
  (GET ["/matrices/:id" :id id-re] [id]
    (show id))
  (POST ["/matrices/:id" :id id-re] [id streams]
    (update id streams))
  (POST "/matrices" []
    (create)))
