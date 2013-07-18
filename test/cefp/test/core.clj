(ns cefp.test.core
  (:use [cefp.core :only (cef-parse cef-find-kv)])
  (:use [clojure.test]))

(deftest test-cef-find-kv
    (is (= "k=v" (cef-find-kv "|||||||k=v")))
    (is (= "k=v k2=v\\|" (cef-find-kv "|||||||k=v k2=v\\|")))
    (is (= "k2=v\\|k3=4" (cef-find-kv "|||||||k2=v\\|k3=4")))
	)

(deftest test-cef-parse
	(is (= {:k "v"} (cef-parse "|||||||k=v")))
        (is (= {:what "what what"} (cef-parse "|||||||what=what what")))
	)
