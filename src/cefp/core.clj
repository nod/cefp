(ns cefp.core
	(:use [clojure.string :only (split)])
	)

(defn cef-find-kv [cefs]
	(last (split cefs #"\|" 8))
	)

(defn keyval [s]
	(map (fn [n] (take-last 2 n)) (re-seq #"(\w+)\=(.+?)" s))
	)

(defn symval [k v] [(keyword k) v])


(defn cef-parse [cefs]
	(into {} (map (fn [[k v]] (symval k v)) (keyval (cef-find-kv cefs))))
	)

(def cefsample "|||||||k=v")
(def biggersample "|||||||k=v somedog=my pet cat")

(defn -main
	[]
	(println (cef-parse cefsample))
	(println (cef-parse biggersample))
	)
