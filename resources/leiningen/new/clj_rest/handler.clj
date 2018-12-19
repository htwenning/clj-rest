(ns {{name}}.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [ring.util.response :refer [response]]
            [cheshire.core :as json]))


(def site-defaults-without-anti-forgery
  (assoc-in site-defaults [:security :anti-forgery] false))


(defroutes app-routes
           (GET "/" request (str request))
           (GET "/json" request (response {:message "it works!"}))
           (route/resources "/static")
           (route/not-found "Not Found"))


(def handler
  (-> app-routes
      (wrap-defaults site-defaults-without-anti-forgery)
      (wrap-json-body {:keywords? true :bigdecimals? true})
      (wrap-json-response)))
