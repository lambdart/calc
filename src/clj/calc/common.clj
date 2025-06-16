(ns calc.common
  (:require [com.brunobonacci.mulog :as u]
            [io.pedestal.interceptor :as interceptor]
            [io.pedestal.http.body-params :as body-params]
            [io.pedestal.http.content-negotiation :as cn]
            [calc.util :as util]))

(def content-types
  "Supported content-types."
  ["text/html"
   "text/plain"
   "application/edn"
   "application/json"
   "application/x-www-form-urlencoded"])

(def content-negotiator
  "Content-Type (http header) negotiator."
  (cn/negotiate-content content-types))

(def coerce-body
  "Coerce body."
  {:name ::coerce-body
   :leave (fn [{response :response :as context}]
            (assoc context
                   :response
                   (util/coerce-response response
                                         (util/accepted-type context))))})

(defn log-request
  "Logs `context` request for debugging purposes."
  [context]
  (do
    (u/log ::logger
           ::request (select-keys (:request context)
                                  [:remote-addr
                                   :headers
                                   :uri
                                   :request-method
                                   :query-string
                                   :path-params
                                   :form-params
                                   :json-params]))
    context))

(defn log-response
  "Logs `context` response for debugging purposes."
  [context]
  (do (u/log ::logger ::response (:response context)) context))

(def logger
  "Default logger."
  {:name ::logger
   :enter (fn [context] (log-request context))})

(def body-parser
  "Body information parser."
  (body-params/body-params))

(def common-interceptors
  "Common interceptors."
  [logger
   body-parser
   content-negotiator
   coerce-body])

(defn wrap-interceptor
  "Wrap `f` interceptor with the common ones."
  [f]
  (conj common-interceptors f))

