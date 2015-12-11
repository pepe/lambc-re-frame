(ns lambc.handlers
    (:require [re-frame.core :as re-frame]
              [lambc.db :as db]))

(re-frame/register-handler
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/register-handler
 :inc
  (fn [db _]
    (let [cnt (:counter db)]
      (assoc db :counter (inc cnt)))))

(re-frame/register-handler
 :dec
 (fn [db _]
   (update db :counter dec)))

