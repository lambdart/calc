(ns calc-ui.views
  (:require
   [calc-ui.api :as api]
   [calc-ui.subs :as subs]
   [calc-ui.events :as events]
   [re-frame.core :as re-frame]))

(defn select-input [id label options]
  (let [value (re-frame/subscribe [::subs/form id])]
    [:div.field
     [:label.label label]
     [:div.control
      [:div.select
       [:select
        {:value @value
         :on-change #(re-frame/dispatch
                      [::events/update-form id (-> % .-target .-value)])}
        [:option {:value ""} "Please select"]
        (map (fn [o] [:option {:key o :value o} o]) options)]]]]))

(defn is-valid?
  [form-ids]
  @(re-frame/subscribe [::subs/form-is-valid? form-ids]))

(defn calc-button [id]
  (let [op-id @(re-frame/subscribe [::subs/form :op-id])]
    [:button.button.is-primary
     {:disabled (nil? (api/get-op op-id))
      :on-click #(re-frame/dispatch [::events/calc])}
     "Run"]))

(defn result-output []
  (let [value @(re-frame/subscribe [::subs/result])]
    (when value
      (let [op-id (first (keys value))]
        [:div {:column "is-two-fifths"}
         [:article {:class "message is-info"}
          [:div {:class "message-header"} op-id]
          [:div {:class "message-body"}
           (get value (keyword op-id))]]]))))

(defn error-output []
  (let [value (re-frame/subscribe [::subs/error])]
    (when @value
      [:article {:class "message"}
       [:div {:class "message-header"} "Error"]
       [:div {:class "notification is-danger is-light"} @value]])))

(defn calc-panel []
  [:div.section
   [select-input :op-id "" (keys api/ops)]
   [calc-button]
   [:span " "]
   [:br] [:br]
   [error-output]
   [result-output]])

(defn main-panel []
  (calc-panel))
