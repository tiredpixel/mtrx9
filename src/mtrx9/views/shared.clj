(ns mtrx9.views.shared
  (:use [hiccup.core :only (h)]))

(defn sidebar []
  [:div
    [:h1 "&nbsp;"]
    [:ul
      [:li [:a {:href "/" :class "right"} "home"]]]])
