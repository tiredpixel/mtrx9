(ns mtrx9.controllers.matrices
  (:use [compojure.core :only (defroutes GET POST)])
  (:require [ring.util.response :as ring]
            [mtrx9.views.matrices :as view]))

(def id-chars  "0123456789SLATF-")
(def id-length 42)
(def id-re     (re-pattern (str "[" id-chars "]{" id-length "}")))

(defn- rand-matrix-id []
  (clojure.string/join (repeatedly id-length #(rand-nth id-chars))))

(defn show [id]
  (view/show id))

(defn create []
  (ring/redirect (str "/matrices/" (rand-matrix-id))))

(defroutes routes
  (GET ["/matrices/:id" :id id-re] [id]
    (show id))
  (POST "/matrices" []
    (create)))
