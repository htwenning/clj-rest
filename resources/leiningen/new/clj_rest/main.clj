(ns {{name}}.main
  (:require [{{name}}.handler :refer [app]]
            [ring.adapter.jetty :refer [run-jetty]]))

(def server nil)

(defn start-server []
  (def server (run-jetty #'app {:port 3000 :join? false})))
(defn stop-server []
  (.stop server))
(defn restart-server []
  (.stop server)
  (.start server))

(defn -main []
  (start-server))