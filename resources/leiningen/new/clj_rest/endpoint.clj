(ns {{name}}.components.endpoint
  (:require [com.stuartsierra.component :as component]))


(defrecord Endpoint [build-routes]
  component/Lifecycle
  (start [component]
    (if (:handler component)
      component
      (assoc component :handler (build-routes component))))
  (stop [component]
    (dissoc component :handler)))

(defn endpoint-component [build-routes]
  (->Endpoint build-routes))
