(ns osamaless.csv
  (:require
   [osamaless.types :as t]
   [clojure.java.io :as io]
   [clojure.data.csv :as csv]
   [clojure.string :as string]
   ))


(defn get-people []
  (let [content (-> "sanctionsconlist.csv"
                    (io/resource)
                    (io/reader)
                    (csv/read-csv))]
    (map #(apply t/->Person (map string/trim (take 3 %))) content)))
