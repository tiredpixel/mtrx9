(ns mtrx9.views.matrices
  (:require [mtrx9.views.layout :as layout]))

(defn show [id]
  (layout/common "MTRX9"
    [:div {:id "matrix-id" :class "settings"} id]
    [:div {:id "matrix-outer"}
      [:div {:id "matrix"}]
      [:div {:class "clear"}]]))
