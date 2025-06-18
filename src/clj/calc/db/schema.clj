(ns calc.db.schema
  (:require [datomic.client.api :as d]
            [calc.db.conn :as conn]))

(def ops-schema
  [{:db/ident       :counter/id
    :db/unique      :db.unique/identity
    :db/valueType   :db.type/uuid
    :db/cardinality :db.cardinality/one
    :db/doc         "The id of the operation"}
   {:db/ident       :counter/value
    :db/valueType   :db.type/long
    :db/cardinality :db.cardinality/one
    :db/doc         "The value of the counter"}
   {:db/ident       :counter/created-at
    :db/valueType   :db.type/instant
    :db/cardinality :db.cardinality/one
    :db/doc         "Instant the record is created"}])

(defn setup-schema
  "Setup the operations schema."
  []
  (d/transact @conn/conn {:tx-data ops-schema}))
