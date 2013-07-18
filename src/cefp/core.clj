(ns cefp.core
  (:use [clojure.string :only [trim split]]))

(defn cef-find-kv [cefs]
  (last (split cefs #"\|" 8)))

(defn cef-keys [s]
  (map #(keyword (trim (second %))) (re-seq #"(\w+)=" s)))

(defn cef-values [s]
  (map #(trim %) (drop 1 (split s #"(\w+)="))))

(defn cef-parse [cefs]
  (let [s (cef-find-kv cefs)]
    (zipmap (cef-keys s) (cef-values s))))

(def cefsample "|||||||k=v")
(def biggersample "|||||||k=v somedog=my pet cat")
(def biggestsample "|||||||k=v somedog=my pet cat what=what what yo=swdw")

(defn -main
  []
  (println (cef-parse cefsample))
  (println (cef-parse biggersample))
  (println (cef-parse biggestsample))
  )
