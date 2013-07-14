(ns mtrx9.views.statics
  (:use [hiccup.core :only (h)])
  (:require [mtrx9.views.layout :as layout]
            [mtrx9.views.shared :as shared]))

(defn index []
  (layout/common "MTRX9" [:div
    [:div {:class "pane pane-50 left"}
      (shared/sidebar)]
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

(defn about []
  (layout/common "About | MTRX9" [:div
    [:div {:class "pane pane-50 left"}
      (shared/sidebar)]
    [:div {:class "pane pane-50 right"}
      [:h1 "About"]
      [:p "MTRX9 is written in Clojure."]
      [:p "Fork it on " [:a {:href "https://github.com/tiredpixel/mtrx9"} "GitHub"] "."]
      [:p "Tweet " [:a {:href "https://twitter.com/mtrx9"} "@mtrx9"] "."]
      [:p "More sleep lost by " [:a {:href "http://www.tiredpixel.com"} "tiredpixel"] "."]]]))
