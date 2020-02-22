(defproject {{name}} "0.1.0-SNAPSHOT"
            :description "FIXME: write description"
            :url "http://example.com/FIXME"
            :min-lein-version "2.0.0"
            :dependencies [[org.clojure/clojure "1.9.0"]
                           [compojure "1.6.1"]
                           [ring/ring-defaults "0.3.2"]
                           [ring/ring-json "0.4.0"]
                           [ring/ring-jetty-adapter "1.7.0"]
                           [hiccup "1.0.5"]
                           [ring-jetty-component "0.3.1"]
                           [com.stuartsierra/component "0.3.2"]
                           [aero "1.1.3"]
                           [hikari-cp "2.6.0"]
                           [org.clojure/java.jdbc "0.7.8"]
                           [mysql/mysql-connector-java "8.0.13"]
                           [yesql "0.5.3"]]
            :plugins [[lein-ring "0.12.5"]]
            :ring {:handler {{name}}.handler/app}
            :profiles
            {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring/ring-mock "0.3.2"]
                                  [org.clojure/tools.namespace "0.2.11"]]
                   :source-paths ["dev"]}})
