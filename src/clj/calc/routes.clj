(ns calc.routes
  (:require [calc.handler :as handler]
            [calc.common :as common]))

(def routes
  "Routes declaration."
  #{["/v1/increment" :get (common/wrap-interceptor `handler/increment)]
    ["/v1/reset" :get (common/wrap-interceptor `handler/reset)]})
