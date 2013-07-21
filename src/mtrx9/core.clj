(ns mtrx9.core
  (:use [compojure.core :only (defroutes)]
        [aleph.http :only (start-http-server wrap-ring-handler)])
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [mtrx9.controllers.statics :as statics]
            [mtrx9.controllers.matrices :as matrices]))

(defroutes app-routes
  statics/routes
  matrices/routes
  (route/resources "/"))

(defn -main [port]
  (start-http-server (wrap-ring-handler (handler/api app-routes))
    {:port (Integer. port) :websocket true}))
