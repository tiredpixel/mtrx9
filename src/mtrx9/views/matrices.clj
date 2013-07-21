(ns mtrx9.views.matrices
  (:require [mtrx9.views.layout :as layout]))

(defn show [id]
  (layout/common "MTRX9"
    [:div {:id "matrix-id"} id]
    [:div
      [:div {:id "matrix"}]]))
