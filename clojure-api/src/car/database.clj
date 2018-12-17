(ns car.database
  (:require [korma.db :as korma]))

(def db-connection-info
  (korma/mysql
    {:classname "com.mysql.jdbc.Driver"
     :subprotocol "mysql"
     :user "root"
     :password "root"
     :subname "//localhost:3306/clojurestudies"}))

; set up korma
(korma/defdb db db-connection-info)