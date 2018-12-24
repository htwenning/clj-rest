(ns {{name}}.db.mysql
  (:require [yesql.core :refer [defqueries]]))

(defqueries "queries/queries.sql")