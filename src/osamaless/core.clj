(ns osamaless.core
  (:require
   [osamaless.csv :as csv-downloader]
   ;; [clojure.java.io :as io]
   ;; [clojure.zip :as zip]
   ;; [clojure.data.zip :as dz]
   ;; [clojure.data.zip.xml :as dzx]
   ;; [clojure.data.csv :as csv]
   ;; [clojure.data.xml :as xml]
   [osamaless.types :as t]
   ))

(def people (csv-downloader/get-people))

(println (first people))


;; (def info ["Carl" 20])

;; (defrecord rec []
;;   prot
;;   (f [this] "one arg")
;;   (f [this & rest] "more than one arg"))

;; (defprotocol Downloader
;;   (download [this]))

;; (defrecord CsvDownloader []
;;     Downloader
;;     (download [this] (prn "hello")))

;; (def downloader (CsvDownloader.))

;; (download downloader)

;; (apply ->Person info)
;; -> #user.Person{:name "Carl", :age 20}

;; This is particularly useful for mapping parsed CSV files to records
;; (map #(apply ->Person %) parsed-csv-file)

;; (def url "https://www.treasury.gov/ofac/downloads/sdn.xml")

;;   (def file "sdn.xml")

;; (def x (-> file
;;            (io/resource)
;;            (io/reader)
;;            (xml/parse)))

;; (def zip (zip/xml-zip x))

;; (def result (-> zip
;;                 (zip/down)
;;                 (zip/down)
;;                 ))


;; (-> Person (nth content 2))
