(ns {{name}}.template
  (:use hiccup.core
        hiccup.util
        hiccup.def))

(def doctype
  {:html4
   (str "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\" "
        "\"http://www.w3.org/TR/html4/strict.dtd\">\n")
   :xhtml-strict
   (str "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" "
        "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n")
   :xhtml-transitional
   (str "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" "
        "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n")
   :html5
   "<!DOCTYPE html>\n"})

(defn xml-declaration
  "Create a standard XML declaration for the following encoding."
  [encoding]
  (str "<?xml version=\"1.0\" encoding=\"" encoding "\"?>\n"))

(defelem xhtml-tag
         "Create an XHTML element for the specified language."
         [lang & contents]
         [:html {:xmlns "http://www.w3.org/1999/xhtml"
                 "xml:lang" lang
                 :lang lang}
          contents])

(defmacro html5
  "Create a HTML5 document with the supplied contents."
  [options & contents]
  (if-not (map? options)
    `(html5 {} ~options ~@contents)
    (if (options :xml?)
      `(let [options# (dissoc ~options :xml?)]
         (html {:mode :xml}
               (xml-declaration (options# :encoding "UTF-8"))
               (doctype :html5)
               (xhtml-tag options# (options# :lang) ~@contents)))
      `(let [options# (dissoc ~options :xml?)]
         (html {:mode :html}
               (doctype :html5)
               [:html options# ~@contents])))))