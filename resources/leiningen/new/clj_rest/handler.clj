(ns {{name}}.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [ring.util.response :refer [response]]
            [cheshire.core :as json]
            [{{name}}.db :as sql]))


(def site-defaults-without-anti-forgery
  (assoc-in site-defaults [:security :anti-forgery] false))

(defn create-app
  ""
  [db]
  (-> (routes
        (GET "/" request (str request))
        (GET "/json" request (response {:message "hello"}))
        (GET "/mysql" request (response {:data (sql/query-user db (:id (:params request)))}))
        (route/resources "/static")
        (route/not-found "Not Found"))
      (wrap-defaults site-defaults-without-anti-forgery)
      (wrap-json-body {:keywords? true :bigdecimals? true})
      (wrap-json-response)))

(defn build-routes
  "build routes from component"
  [component]
  (create-app (:db component)))