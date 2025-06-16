(ns calc.config
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]))

(def default-edn-file
  "Configuration file defined in deps.edn."
  (System/getProperty "config"))

(defn read-edn-file
  "Read edn config file."
  [& [edn-file]]
  (try
    (with-open [s (io/reader (or edn-file default-edn-file))]
      (edn/read (java.io.PushbackReader. s)))
    (catch Exception _ {})))

(defn get-edn-value
  "Get config value from `edn-file` using `key` identifier."
  ([key] (get-edn-value key default-edn-file))
  ([key edn-file]
   (get (read-edn-file edn-file) key)))

;; Revise documentation
(defn get-edn-in
  "Get values in value using `keys`."
  [& keys]
  (get-in (read-edn-file) (vec keys)))

(defn get-env-value
  "Get `value` value from the environment."
  [value]
  (or (System/getenv value) ""))
