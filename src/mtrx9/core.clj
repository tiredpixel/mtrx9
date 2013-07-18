(ns mtrx9.core
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.adapter.jetty :as jetty]
            [mtrx9.controllers.statics :as statics]
            [mtrx9.controllers.matrices :as matrices]
            [mtrx9.views.layout :as layout]))

(defroutes app-routes
  statics/routes
  matrices/routes
  (route/resources "/"))

(def app
  (handler/api app-routes))

(defn -main [port]
  (jetty/run-jetty app {:port (Integer. port) :join? false}))
