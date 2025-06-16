(ns calc.handler
  (:require [calc.util :as util]
            [calc.action :as action]))

(defmacro gen-handler
  "Generate action handler."
  [{action-id :action-id
    action-fn :action-fn}]
  `(fn [request#]
     (-> request#
         (#(~action-fn %))
         (#(util/->resp-map ~action-id %))
         (util/ok))))

(def increment
  "Increment handler."
  (gen-handler {:action-id :increment
                :action-fn action/increment}))

(def reset
  "Reset handler."
  (gen-handler {:action-id :reset
                :action-fn action/reset}))
