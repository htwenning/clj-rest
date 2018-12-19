(ns {{name}}.system
  (:require [{{name}}.handler :refer [handler]]
            [ring.component.jetty :refer [jetty-server]]
            [com.stuartsierra.component :as component]
            [{{name}}.config :refer [config]]))


(defn new-system
  "return a new {{name}} system."
  []
  (let [config @config]
       (-> (component/system-map
             :http (jetty-server (assoc
                                   (:http config)
                                   :app {:handler handler}))))))