(ns mtrx9.controllers.statics
  (:use [compojure.core :only (defroutes GET)])
  (:require [ring.util.response :as ring]
            [mtrx9.views.statics :as view]))

(defn index []
  (view/index))

(defroutes routes
  (GET  "/" [] (index)))
