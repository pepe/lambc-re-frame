(ns lambc.views
    (:require [re-frame.core :as re-frame]))

(defn main-panel []
  (let [name (re-frame/subscribe [:name])
        counter (re-frame/subscribe [:counter])]
    (fn []
      [:div
       [:div "Čau z " @name]
       [:button
        {:on-click #(re-frame/dispatch [:inc])}
        "+"]
       [:button
        {:on-click (fn [] (re-frame/dispatch [:dec]))}
        "-"]
       [:span @counter] ])))
