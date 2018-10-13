(ns {{name}}.main
  (:require [{{name}}.handler :refer [app]]
            [ring.adapter.jetty :refer [run-jetty]]))


(defn -main []
  (run-jetty app {:port 3000}))