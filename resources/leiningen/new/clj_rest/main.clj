(ns {{name}}.main
  (:require [{{name}}.system :as system]))


(defn -main []
  (.start (system/new-system)))