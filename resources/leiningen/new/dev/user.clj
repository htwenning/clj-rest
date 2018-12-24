(ns user
  (:require [clojure.tools.namespace.repl :refer [refresh refresh-all]]
            [{{name}}.system :as system]
            [com.stuartsierra.component :as component]))


(def system nil)

(defn init
  "construct system"
  []
  (alter-var-root #'system
                  (constantly (system/new-system))))

(defn start
  []
  (alter-var-root #'system component/start))

(defn stop []
  (alter-var-root #'system component/stop))

(defn go []
  (init)
  (start))

(defn reset []
  (stop)
  (refresh :after 'user/go))

(defn reset-all []
  (stop)
  (refresh-all :after 'user/go))
