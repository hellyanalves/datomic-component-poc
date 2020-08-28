(ns school-poc.model
  (:require [schema.core :as s]
            [school-poc.schema :as schema]))

(s/set-fn-validation! true)

(defn new-student [name document age] :- schema/student-schema
  {:student/name name
   :student/document document
   :student/age age})