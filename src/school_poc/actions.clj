(ns school-poc.actions
  (:require [school-poc.database :as s.db]))

(defn save-new-student [database student]
  (let [conn (:connection database)]
    (s.db/insert-to-database conn [student])))

