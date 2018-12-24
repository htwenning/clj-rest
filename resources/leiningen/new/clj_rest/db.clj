(ns {{name}}.db
  (:require [{{name}}.db.mysql :as mysql]))


(defn query-user [db id]
  (mysql/query-user {:id id} {:connection db}))
