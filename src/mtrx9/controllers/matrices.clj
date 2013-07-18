(ns mtrx9.controllers.matrices
  (:use [compojure.core :only (defroutes GET POST)])
  (:require [ring.util.response :as ring]
            [mtrx9.views.matrices :as view]))

(defn show [id]
  (view/show id))

(defn create []
  (ring/redirect (str "/matrices/"
                      (apply str (repeatedly 42 #(rand-nth "0123456789-SLATF"))))))

(defroutes routes
  (GET  "/matrices/:id" [id] (show id))
  (POST "/matrices" [] (create)))
