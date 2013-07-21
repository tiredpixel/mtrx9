(ns mtrx9.views.matrices
  (:require [mtrx9.views.layout :as layout]))

(defn show [id]
  (layout/common "MTRX9"
    [:div {:id "matrix-id" :class "settings"}]
    [:div {:id "header" :class "container"}
      [:p {:class "title"} [:a {:href "/"} "MTRX9"]]
      [:p {:class "copyright"} [:a {:href "http://www.tiredpixel.com"} "tiredpixel"]]]
    [:div {:class "placeholder"}
      [:h1 "Ready"]
      [:p "POST data to this matrix:"]
      [:p "$ curl URL -d 'streams[a]=1&streams[É]=д'"]]
    [:div {:id "matrix-outer"}
      [:div {:id "matrix"}]
      [:div {:class "clear"}]]))
