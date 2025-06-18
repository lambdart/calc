(ns calc.db.db
  (:require [datomic.client.api :as d]))

(defn create-database
  "Create a database using the `dbname` identifier."
  [client dbname]
  (d/create-database client {:db-name dbname}))

(defn list-databases
  "List databases."
  [client]
  (d/list-databases client {}))

(defn delete-database
  "Delete database identify by `dbname`."
  [client dbname]
  (d/delete-database client {:db-name dbname}))

(defn delete-databases
  "Delete all databases`."
  [client]
  (mapv #(delete-database client %)
        (list-databases client)))
