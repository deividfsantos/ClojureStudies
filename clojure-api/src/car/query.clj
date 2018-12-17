(ns car.query
  (:require [car.database]
            [korma.core :refer :all]))

(defentity car)

(defn get-cars []
  (select car))

(defn add-car [name brand color amount]
  (insert car
          (values {:name name :brand brand :color color :amount amount})))

(defn delete-car [id]
  (delete car
          (where {:id [= id]})))

(defn update-car [id name is-complete]
  (update car
          (set-fields {:name        name
                       :is_complete is-complete})
          (where {:id [= id]})))

(defn get-car [id]
  (first
    (select car
            (where {:id [= id]}))))