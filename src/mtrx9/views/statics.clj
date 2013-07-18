(ns mtrx9.views.statics
  (:use [hiccup.core :only (h)]
        [hiccup.form :only (form-to submit-button)])
  (:require [mtrx9.views.layout :as layout]))

(defn index []
  (layout/sidebar-right "MTRX9"
    [:div
      [:h1 "MTRX9"]
      [:p "Keep an eye on many things."]
      [:p "1 character at a time."]
      [:p "3 dimensions:"]
      [:ul
        [:li "streams"]
        [:li "values"]
        [:li "time"]]
      [:div
        (form-to [:post "/matrices"]
          (submit-button "create"))]]))

(defn about []
  (layout/sidebar-right "About | MTRX9"
    [:div
      [:h1 "About"]
      [:p "MTRX9 is written in Clojure."]
      [:p "Fork it on " [:a {:href "https://github.com/tiredpixel/mtrx9"} "GitHub"] "."]
      [:p "Tweet " [:a {:href "https://twitter.com/mtrx9"} "@mtrx9"] "."]
      [:p "More sleep lost by " [:a {:href "http://www.tiredpixel.com"} "tiredpixel"] "."]]))
