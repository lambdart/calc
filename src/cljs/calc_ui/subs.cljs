(ns calc-ui.subs
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::result
 (fn [db [_]]
   (get db :result)))

(re-frame/reg-sub
 ::error
 (fn [db [_]]
   (get db :error)))

(re-frame/reg-sub
 ::form
 (fn [db [_ id]]
   (get-in db [:form id] "")))

(re-frame/reg-sub
 ::form-is-valid?
 (fn [db [_ form-ids]]
   (every? #(get-in db [:form %]) form-ids)))
