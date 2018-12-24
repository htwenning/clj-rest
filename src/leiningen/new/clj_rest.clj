(ns leiningen.new.clj-rest
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def source-render (renderer "clj-rest"))
(def resources-render (renderer "resources"))
(def project-root-render (renderer "project-root"))
(def dev-render (renderer "dev"))

(defn clj-rest
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' clj-rest project.")
    (->files data
             ["src/{{sanitized}}/handler.clj" (source-render "handler.clj" data)]
             ["src/{{sanitized}}/main.clj" (source-render "main.clj" data)]
             ["src/{{sanitized}}/system.clj" (source-render "system.clj" data)]
             ["src/{{sanitized}}/config.clj" (source-render "config.clj" data)]
             ["src/{{sanitized}}/template.clj" (source-render "template.clj" data)]
             ["src/{{sanitized}}/db.clj" (source-render "db.clj" data)]
             ["src/{{sanitized}}/components/endpoint.clj" (source-render "endpoint.clj" data)]
             ["src/{{sanitized}}/components/hikari.clj" (source-render "hikari.clj" data)]
             ["src/{{sanitized}}/db/mysql.clj" (source-render "mysql.clj" data)]
             ["readme.md" (project-root-render "readme.md" data)]
             ["project.clj" (project-root-render "project.clj" data)]
             ["resources/public/static.html" (resources-render "static.html")]
             ["resources/default_config.edn" (resources-render "default_config.edn")]
             ["resources/queries/queries.sql" (resources-render "queries.sql")]
             ["dev/user.clj" (dev-render "user.clj" data)])))
