(ns {{name}}.system
  (:require [{{name}}.handler :refer [build-routes]]
            [ring.component.jetty :refer [jetty-server]]
            [com.stuartsierra.component :as component]
            [{{name}}.config :refer [config]]
            [{{name}}.components.hikari :refer [new-hikari-cp]]
            [{{name}}.components.endpoint :refer [endpoint-component]]))



(defn new-system
  "return a new rest system."
  []
  (let [config @config]
    (-> (component/system-map
          :app (endpoint-component build-routes)
          :http (jetty-server (:http config))
          :db (new-hikari-cp (:db config)))
        (component/system-using
          {:app [:db]
           :http [:app]}))))