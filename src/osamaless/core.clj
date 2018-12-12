(ns osamaless.core
  (:require
   [osamaless.csv :as csv-downloader]
   [osamaless.xml :as xml-downloader]))

(xml-downloader/extract-people)
(csv-downloader/get-people)
(csv-downloader/extract-people)
