(ns school-poc.database
  (:require [datomic.api :as d]))

(def db-schema [{:db/ident       :student/name
                 :db/valueType   :db.type/string
                 :db/cardinality :db.cardinality/one
                 :db/doc         "Student name"}
                {:db/ident       :student/document
                 :db/valueType   :db.type/string
                 :db/cardinality :db.cardinality/one
                 :db/doc         "Student document number"}
                {:db/ident       :student/age
                 :db/valueType   :db.type/int
                 :db/cardinality :db.cardinality/one
                 :db/doc         "Student age"}])

(defn create-schema [conn]
  (d/transact conn db-schema))

(defn insert-to-database [conn data]
  (d/transact conn data))

(defn open-connection [db-uri]
  (d/create-database db-uri)
  (d/connect db-uri))

(defn get-schema [uri]
  (d/get-database-names uri))