(ns calc.op
  (:require [calc.db.counter :as counter]))

(defn increment
  "Increment counter by one."
  [& [_]]
  (->
   (counter/increment)
   ((fn[_] (counter/get-counter)))
   (:value)))

(defn reset
  "Reset counter to zero."
  [& [_]]
  (-> (counter/reset)
      ((fn[_] (counter/get-counter)))
      (:value)))
