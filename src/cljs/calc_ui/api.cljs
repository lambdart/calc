(ns calc-ui.api)

(def url "http://localhost:8080/v1")

(def ops
  "Operation map"
  {"increment" "/increment",
   "reset" "/reset"})

(defn get-op
  "Get the operation."
  [op-id]
  (get ops op-id))
