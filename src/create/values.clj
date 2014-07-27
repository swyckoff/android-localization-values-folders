(ns create.values
  (:require [clojure.java.io :as io])
  (:gen-class))

(def input-file-name "languages.txt")
(def template-file "strings.xml")
(def dir-results "dirs")

(defn copy-template
  [fparent]
  (with-open
      [rdr (->> template-file
            (io/resource)
            (io/reader))
       wrt (io/writer (str dir-results "/" fparent "/" template-file))]
    (doseq [line (line-seq rdr)]
      (.write wrt (str line "\n")))))

(defn read-languages
  []
  (slurp (io/resource input-file-name)))

(defn convert-string-to-map
  [string]
  (clojure.string/split string #"\n"))

(defn prepend-values
  [xs]
  (map #(str "values-" %) xs))

(defn make-and-fill-dirs
  [xs]
  (dorun
   (map #(do (.mkdir (io/file dir-results %))
             (copy-template %)) xs)))

(defn create-language-dirs
  []
  (.mkdir (io/file dir-results)) ;; for folders
  (->> (read-languages)
       (convert-string-to-map)
       (prepend-values)
       (make-and-fill-dirs)))

(defn -main
  []
  (create-language-dirs))
