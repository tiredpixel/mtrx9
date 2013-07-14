(ns mtrx9.views.layout
  (:use [hiccup.core :only (html)]
        [hiccup.page :only (html5 include-css include-js)])
  (:require [mtrx9.views.shared :as shared]))

(defn common [title & body]
  (html5
    [:head
      [:meta {:charset "utf-8"}]
      [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
      [:meta {:name "viewport" :content "width=device-width, initial-scale=1, maximum-scale=1"}]
      [:title title]
  (include-css "//openfontlibrary.org/face/average-mono")]
  (include-css "/stylesheets/reset.css"
               "/stylesheets/screen.css")
  [:body
    [:div {:id "header" :class "container"} ""]
    [:div {:id "content" :class "container"} body]
    (include-js "//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js")
    (include-js "/javascripts/application.js")]))

(defn sidebar-right [title right]
  (common title [:div
    [:div {:class "pane pane-50 left"}
      (shared/sidebar)]
    [:div {:class "pane pane-50 right"}
      right]]))
