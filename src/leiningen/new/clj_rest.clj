(ns leiningen.new.clj-rest
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "clj-rest"))

(defn clj-rest
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' clj-rest project.")
    (->files data
             ["src/{{sanitized}}/handler.clj" (render "handler.clj" data)]
             ["src/{{sanitized}}/main.clj" (render "main.clj" data)]
             ["readme.md" (render "readme.md" data)]
             ["project.clj" (render "project.clj" data)]
             ["resources/public/static.html" (render "static.html")])))
