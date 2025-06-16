(ns calc.util
  (:require [clojure.string :as s]
            [clojure.data.json :as json]
            [com.brunobonacci.mulog :as u]))

(defn transform-body
  "Transform `body` accordingly to `content-type`."
  [body content-type]
  (case content-type
    "text/html" body
    "text/plain" body
    "application/edn" (pr-str body)
    ;; default
    "application/json" (json/write-str body)))

(defn accepted-type
  "Return a acceptable content-type from the `context`."
  [context]
  (get-in context [:request :accept :field] "application/json"))

(defn coerce-response
  "Coerce the `response` body to a acceptable `content-type`."
  [response content-type]
  (-> response
      (update :body transform-body content-type)
      (assoc-in [:headers "Content-Type"] content-type)))

(defn ->resp-map
  "Parse response map."
  [k v]
  (assoc {} k v))

(defn make-response
  "Make a `status`, `body` and `headers` (optional) response map."
  [status body & {:as headers}]
  {:status status
   :body body
   :headers (or headers {"Content-Type" "application/json"})})

(def ok
  "Define the ok response function."
  (partial make-response 200))

(defn attach-response
  "Attach `response` to the `context`.
  Implicitly will short circuit the interceptors queue chain."
  [context response]
  (assoc context :response response))
