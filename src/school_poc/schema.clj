(ns school-poc.schema
  (:require [schema.core :as s]))

(def student-schema
  {:student/name     s/Str
   :student/document s/Str
   :student/age      s/Int})

