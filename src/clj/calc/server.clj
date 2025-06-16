(ns calc.server
  (:require [calc.routes :as routes]
            [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]))

;; server instance
(defonce server (atom nil))

(defn setup
  "Server setup."
  [cfg]
  (-> cfg
      (merge {;; don't block the main threada
              ::http/join? false
              ;; routes can be a function that resolve routes,
              ;; set the routes to be re-loadable
              ::http/routes #(route/expand-routes (deref #'routes/routes))
              ;; all origins are allowed in dev mode
              ::http/allowed-origins {:creds true
                                      :allowed-origins (constantly true)}})
      ;; wire up interceptor chains
      (http/default-interceptors)))

(defn start
  "Start the http server using the server
  parameters from `cfg` map."
  [cfg]
  (-> cfg
      (setup)
      (http/create-server)
      (http/start)))

(defn- -reset!
  "Reset the http server instance using the
  server parameters from map `cfg` (config)."
  [cfg]
  (reset! server (-> cfg
                     (setup)
                     (start))))

(defn stop!
  "Stop the http server."
  [& [_]]
  (reset! server
          (dorun
           (when @server
             (-> @server http/stop)))))

(defn restart
  "Stop and reset the http server using the
  parameters `host`, `port` and `type`."
  [host port type]
  (doseq [f [stop! -reset!]]
    (f {::http/host host
        ::http/type type
        ::http/port port})))
