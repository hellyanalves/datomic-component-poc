(ns school-poc.core
  (:require [school-poc.actions :as s.actions]
            [com.stuartsierra.component :as component]
            [school-poc.component :as s.component]
            [school-poc.model :as s.model]
            [school-poc.database :as db]
            [datomic.api :as d]))

(def ^:private system-config
  {:db {:uri "datomic:dev://localhost:4334/school"}})

(defn example-system [config-options]
  (component/system-map
    :database (s.component/->Database (-> config-options :db :uri))))

(def ^:private system-map
  (-> system-config
      example-system
      component/start-system))

(let [student (s.model/new-student "Hellyan" "123" 25)
      ;student [{:student/name "Hellyan", :student/document "123", :student/age 25}]
      database (-> system-map :database)]
  ;conn (d/connect "datomic:dev://localhost:4334/school")]
  ;(clojure.pprint/pprint conn)
  ;(clojure.pprint/pprint student)
  (db/create-schema (:connection database))
  ;(clojure.pprint/pprint (d/transact conn student))
  (clojure.pprint/pprint (s.actions/save-new-student
                           database student)))

(defn -main [& _])
