(ns calc.routes-fixture
  (:require [calc.server :as server]
            [calc.config :as config]))

(defn restart-fixture
  [test-fns]
  (do
    (let [{host :host
           port :port} (-> :calc/http config/get-edn-value)]
      (doseq [f [#(server/restart host port :jetty)
                 #(test-fns)]]
        (f)))))
