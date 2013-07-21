(ns mtrx9.views.statics
  (:use [hiccup.form :only (form-to submit-button)])
  (:require [mtrx9.views.layout :as layout]))

(defn home []
  (layout/sidebar-right "MTRX9"
    [:div
      [:h1 "MTRX9"]
      [:p "Keep an eye on many things."]
      [:p "Simple monitoring in 3 dimensions:"]
      [:ul
        [:li "streams"]
        [:li "chars"]
        [:li "time"]]
      [:div
        (form-to [:post "/matrices"]
          (submit-button "create"))]]))

(defn about []
  (layout/sidebar-right "About | MTRX9"
    [:div
      [:h1 "About"]
      [:p "MTRX9 is written in Clojure. It uses Websockets."]
      [:p "Fork it on " [:a {:href "https://github.com/tiredpixel/mtrx9"} "GitHub"] "."]
      [:p "Tweet " [:a {:href "https://twitter.com/mtrx9"} "@mtrx9"] "."]
      [:p "More sleep lost by " [:a {:href "http://www.tiredpixel.com"} "tiredpixel"] "."]]))
