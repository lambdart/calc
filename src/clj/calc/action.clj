(ns calc.action)

(def counter (atom 0))

(defn increment
  "Increment counter by one."
  [_]
  (swap! counter inc))

(defn reset
  "Reset counter to zero."
  [_]
  (reset! counter 0))
