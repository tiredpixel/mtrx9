(ns mtrx9.views.shared)

(defn sidebar []
  [:div
    [:h1 "&nbsp;"]
    [:ul
      [:li [:a {:href "/" :class "right"} "home"]]
      [:li [:a {:href "/about" :class "right"} "about"]]]])
