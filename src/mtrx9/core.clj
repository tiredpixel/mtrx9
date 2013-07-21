(ns mtrx9.core
  (:use compojure.core
        lamina.core
        aleph.http)
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

(defn -main [port]
  (start-http-server (wrap-ring-handler (handler/api app-routes))
    {:port (Integer. port) :websocket true}))
