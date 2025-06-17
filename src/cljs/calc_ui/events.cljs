(ns calc-ui.events
  (:require [ajax.core :as ajax]
            [re-frame.core :as re-frame]
            [day8.re-frame.http-fx]
            [day8.re-frame.tracing :refer-macros [fn-traced]]
            [calc-ui.api :as api]))

(defn ajax-request
  [uri method params success failure]
  {:http-xhrio {:uri uri
                :method method
                :params params
                :timeout 500
                :format (ajax/url-request-format)
                :response-format (ajax/json-response-format {:keywords? true})
                :on-success [success]
                :on-failure [failure]}})

(re-frame/reg-event-db
 ::update-form
 (fn [db [_ id val]]
   (let [result (:result db)]
     (-> db
         (#(if result (dissoc % :result) (identity %)))
         (assoc-in [:form id] val)))))

(re-frame/reg-event-fx
 ::calc
 (fn [{:keys [db]} _]
   (let [{op-id :op-id} (:form db)]
     (merge {:db (-> db (dissoc :result :error))}
            {:http-xhrio {:uri (str api/url (api/get-op op-id))
                          :method :get
                          :timeout 500
                          :response-format (ajax/json-response-format {:keywords? true})
                          :headers {}
                          :on-success [::calc-success]
                          :on-failure [::calc-failure]}}))))

(re-frame/reg-event-db
 ::calc-success
 (fn [db [_ response]]
   (-> db (assoc :result response))))

(re-frame/reg-event-db
 ::calc-failure
 (fn [db [_ response]]
   (-> db (assoc :error (:status-text response)))))
