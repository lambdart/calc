(ns calc.handler
  (:require [calc.util :as util]
            [calc.op :as op]))

(defmacro gen-handler
  "Generate op handler."
  [{op-id :op-id
    op-fn :op-fn}]
  `(fn [request#]
     (-> request#
         (#(~op-fn %))
         (#(util/->resp-map ~op-id %))
         (util/ok))))

(def increment
  "Increment handler."
  (gen-handler {:op-id :increment
                :op-fn op/increment}))

(def reset
  "Reset handler."
  (gen-handler {:op-id :reset
                :op-fn op/reset}))
