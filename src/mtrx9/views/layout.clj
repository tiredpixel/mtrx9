(ns mtrx9.views.layout
  (:use [hiccup.page :only (html5 include-css include-js)]
        [hiccup.element :only (javascript-tag)])
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
    (include-js "/javascripts/application.js")
    (javascript-tag (str
      "(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
      (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
      m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
      })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
      ga('create', '" (System/getenv "GOOGLE_ANALYTICS_TRACKER") "', '" (System/getenv "GOOGLE_ANALYTICS_NAME") "');
      ga('send', 'pageview');"))]))

(defn sidebar-right [title right]
  (common title [:div
    [:div {:class "pane pane-50 left"}
      (shared/sidebar)]
    [:div {:class "pane pane-50 right"}
      right]]))
