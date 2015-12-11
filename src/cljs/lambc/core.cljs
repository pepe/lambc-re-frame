(ns lambc.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [lambc.handlers]
              [lambc.subs]
              [lambc.views :as views]
              [lambc.config :as config]))

(when config/debug?
  (println "dev mode"))

(defn mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init [] 
  (re-frame/dispatch-sync [:initialize-db])
  (mount-root))
