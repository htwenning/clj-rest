(ns {{name}}.main
  (:require [{{name}}.handler :refer [app]]
            [ring.adapter.jetty :refer [run-jetty]]))

(def server (delay (run-jetty app {:port 3000 :join? false})))
;(defn -main []
;  (.start @server))