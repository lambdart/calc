(ns calc.db.query
  (:require [datomic.client.api :as d]))

(defn upsert-one!
  "Update or insert one record."
  [conn {:keys [id value created-at]}]
  (d/transact conn {:tx-data [[:db/add "temp-id" :counter/id id]
                              [:db/add "temp-id" :counter/value value]
                              [:db/add "temp-id" :counter/created-at created-at]]}))

(defn upsert-one-map!
  "Upsert or insert one record using map."
  [conn {:keys [id value created-at]}]
  (d/transact conn {:tx-data [{:counter/id id
                               :counter/value value
                               :counter/created-at created-at}]}))

(defn retract-one!
  "Retract all the fields based on the `id`."
  [conn id]
  (try
    (d/transact conn {:tx-data
                      [[:db/retract [:counter/id id] :counter/id]
                       [:db/retract [:counter/id id] :counter/value]
                       [:db/retract [:counter/id id] :counter/created-at]]})
    (catch Exception e {})))

(defn find-all!
  "Return all records from the database `db`."
  [db]
  (d/q '[:find ?id ?counter ?created-at
         :keys id value created-at
         :where
         [?e :counter/id ?id]
         [?e :counter/value ?counter]
         [?e :counter/created-at ?created-at]]
       db))

(defn find-by-id!
  "Find record in the `db` using its `id`."
  [db id]
  (-> (d/q '[:find ?id ?value ?created-at
             :keys id value created-at
             :in $ ?id
             :where
             [?e :counter/id ?id]
             [?e :counter/value ?value]
             [?e :counter/created-at ?created-at]]
           db id)
      first))
