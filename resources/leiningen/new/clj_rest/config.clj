(ns {{name}}.config
  (:require [clojure.java.io :as io]
            [aero.core :as aero]))


(def default-config
  (delay
    (if-let [cfg (io/resource "default_config.edn")]
      (aero/read-config cfg)
      (println "failed to find default_config.edn"))))

(def config
  (delay
    (-> @default-config
        (merge (when-let [extract-config (System/getProperty "{{name}}.config.file")]
                 (aero/read-config extract-config))))))
