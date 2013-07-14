(ns mtrx9.views.statics
  (:use [hiccup.core :only (h)])
  (:require [mtrx9.views.layout :as layout]))

(defn index []
  (layout/common "MTRX9" [:div
    [:div {:class "pane pane-50 left"}
      [:h1 "&nbsp;"]
      [:p [:a {:href "/" :class "right"} "home"]]]
    [:div {:class "pane pane-50 right"}
      [:h1 "MTRX9"]
      [:p "Keep an eye on many things."]
      [:p "1 character at a time."]
      [:p "3 dimensions:"]
      [:ul
        [:li "streams"]
        [:li "values"]
        [:li "time"]]
      [:p [:a {:href "#" :class "left"} "create"]]]]))
