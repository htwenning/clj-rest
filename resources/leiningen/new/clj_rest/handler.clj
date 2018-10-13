(ns {{name}}.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [clj-json.core :as json]))


(defn json-response [data & [status]]
  {:headers {"Content-Type" "application/json"}
   :status (or status 200)
   :body (json/generate-string data)})


(defroutes app-routes
           (GET "/" request (str request))
           (GET "/json" request (json-response {:message "it works!"}))
           (route/resources "/static")
           (route/not-found "Not Found"))


(def app
  (wrap-defaults app-routes site-defaults))