(ns calc.db.conn
  (:require [datomic.client.api :as d]
            [calc.config :as config]
            [calc.db.db :as db]))

;; datomic client api instance
(defonce client (atom nil))

;; datomic conn api instance
(defonce conn (atom nil))

;; set client configuration
(def client-cfg (config/get-edn-in :calc/db :client))

;; set db configuration and db name
(def db-cfg (config/get-edn-in :calc/db :db-name))
(def db-name (config/get-edn-in :calc/db :db-name :db-name))

(defn -reset-client!
  "Setup client."
  []
  (reset! client (d/client client-cfg)))

(defn -reset-conn!
  "Create datomic connection."
  []
  (reset! conn (d/connect @client db-cfg)))

(defn -create-database
  "Just a wrapper function that will create the database."
  []
  (db/create-database @client db-name))

(defn setup-client
  "Initialize the datomic client, create first
  database and connect to it."
  []
  (try
    (do
      (-reset-client!)
      (-create-database)
      (-reset-conn!))
    (catch Exception e false)))
