(ns mtrx9.views.matrices
  (:require [mtrx9.views.layout :as layout]))

(defn show [id]
  (layout/common "MTRX9"
    [:div
      [:h1 id]]))
