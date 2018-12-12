(ns osamaless.xml
  (:use [clojure.data.zip.xml :only (text xml->)])
  (:require
    [clojure.java.io :as io]
    [clojure.zip :as zip]
    [clojure.data.xml :as xml]
  ))

(defrecord Person [firstName lastName])

(defn extract-person [element]
  (map->Person {:lastName (first (xml-> (zip/xml-zip element) :lastName text))
                :firstName (first (xml-> (zip/xml-zip element) :firstName text))}))

(defn akas [sdnEntry]
  (let [entries (xml-> (zip/xml-zip sdnEntry) :akaList :aka zip/node)]
    (map #(extract-person %) entries)))

(defn extract-sdn-entry [sdnEntry]
  (cons (extract-person sdnEntry) (akas sdnEntry)))


(defn extract-people []
  (let [x (-> "sdn.xml"
              (io/resource)
              (io/reader)
              (xml/parse))
        zipped (zip/xml-zip x)
        entries (xml-> zipped :sdnEntry zip/node)]
    (flatten (map #(extract-sdn-entry %) entries))))
