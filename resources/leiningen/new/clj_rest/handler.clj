(ns {{name}}.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [ring.util.response :refer [response]]
            [ring.util.anti-forgery :refer [anti-fogery-field]]
            [cheshire.core :as json]))


(def site-defaults-without-anti-forgery
  (merge site-defaults {:security {:anti-forgery         false
                                   :xss-protection       {:enable? true, :mode :block}
                                   :frame-options        :sameorigin
                                   :content-type-options :nosniff}}))


(defroutes app-routes
           (GET "/" request (str request))
           (GET "/json" request (response {:message "it works!"}))
           (route/resources "/static")
           (route/not-found "Not Found"))


(def app
  (-> app-routes
      (wrap-defaults site-defaults-without-anti-forgery)
      (wrap-json-body {:keywords? true :bigdecimals? true})
      (wrap-json-response)))