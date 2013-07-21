(ns mtrx9.controllers.matrices
  (:use [compojure.core :only (defroutes GET POST)]
        lamina.core
        aleph.http
        aleph.formats)
  (:require [ring.util.response :as ring]
            [mtrx9.views.matrices :as view]))

(def id-chars  "0123456789SLATF-")
(def id-length 42)
(def id-re     (re-pattern (str "[" id-chars "]{" id-length "}")))

(defn- rand-matrix-id []
  (clojure.string/join (repeatedly id-length #(rand-nth id-chars))))

(defn websocket-init [channel]
  (receive-all channel #(println "C:" %)))

(defn websocket-handler [channel request]
  (let [matrix-id (get-in request [:route-params :id])
        matrix-channel (named-channel matrix-id websocket-init)]
    (siphon matrix-channel channel)
    (siphon channel matrix-channel)))

(defn show [id]
  (view/show id))

(defn create []
  (ring/redirect (str "/matrices/" (rand-matrix-id))))

(defn update [id chars]
  (println "U:" id chars)
  (enqueue (named-channel id websocket-init) (encode-json->string chars))
  {:status 204})

(defroutes routes
  (GET ["/matrices/:id/websocket" :id id-re] []
    (wrap-aleph-handler websocket-handler))
  (GET ["/matrices/:id" :id id-re] [id]
    (show id))
  (POST ["/matrices/:id" :id id-re] [id chars]
    (update id chars))
  (POST "/matrices" []
    (create)))
