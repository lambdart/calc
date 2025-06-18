(ns calc.main
  (:require [calc.server :as server]
            [calc.config :as config]
            [calc.db.core :as db]
            [com.brunobonacci.mulog :as u]))

(defn -main
  "Parse the http server options and (re)start the
  http server and its routes."
  []
  (let [{host :host
         type :type
         port :port} (-> :calc/http config/get-edn-value)]
    (doseq [f [#(server/restart host port type)
               #(u/start-publisher! {:type :console})
               db/setup-db]]
      (f))))
