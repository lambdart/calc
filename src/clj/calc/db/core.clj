(ns calc.db.core
  (:require [calc.db.conn :as conn]
            [calc.db.schema :as schema]
            [calc.db.counter :as counter]))

(defn setup-db
  "Initialize db service."
  []
  (when (conn/setup-client)
    (doseq [f [schema/setup-schema
               counter/setup-counter]]
      (f))))
