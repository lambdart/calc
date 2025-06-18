(ns calc.db.counter
  (:require [calc.db.query :as query]
            [calc.db.conn :as conn]
            [calc.db.util :as util]
            [calc.db.db :as db]
            [datomic.client.api :as d])
  (:import (java.util Date)))

(defn get-counter
  "Get counter record."
  []
  (first (query/find-all! (d/db @conn/conn))))

(defn increment
  "Increment counter record by one."
  []
  (let [{id :id
         value :value
         createe-at :created-at} (get-counter)]
    (query/upsert-one-map! @conn/conn
                           {:id id
                            :value (inc value)
                            :created-at createe-at})))

(defn reset
  "Reset counter in the record."
  []
  (let [{id :id
         value :value
         createe-at :created-at} (get-counter)]
    (query/upsert-one-map! @conn/conn
                           {:id id
                            :value 0
                            :created-at createe-at})))

(defn setup-counter
  "Create counter default record on
  the database if necessary."
  []
  (when-not (get-counter)
    (query/upsert-one-map! @conn/conn
                           {:id (util/uuid)
                            :value 0
                            :created-at (new Date)})))
