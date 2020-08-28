(ns school-poc.component
  (:require [com.stuartsierra.component :as component]
            [datomic.api :as d]
            [school-poc.database :as db]))

(defrecord Database [db-uri]
  component/Lifecycle
  (start [component]
    (d/create-database db-uri)
    (->> (db/open-connection db-uri)
         (db/create-schema)
         (assoc component :connection)))
  (stop [component]
   (assoc component :connection nil)))
