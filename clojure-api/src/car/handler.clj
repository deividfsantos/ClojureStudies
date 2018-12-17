(ns car.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.json :as json]
            [ring.util.response :refer [response]]
            [car.query :refer :all]))

(defroutes app-routes
           (GET "/v1/cars" []
                (response (get-cars)))

           (GET "/v1/cars/:id" [id]
                (response (get-car (Integer/parseInt id))))

           (POST "/v1/cars" {:keys [params]}
                 (let [{:keys [name brand color amount]} params]
                   (response (add-car name brand color amount))))

           (PUT "/v1/cars/:id" [id name is_complete]
                (response (update-car (Integer/parseInt id) name is_complete)))

           (DELETE "/v1/cars/:id" [id]
                   (response (delete-car (Integer/parseInt id))))

           (route/resources "/")
           (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)
      (json/wrap-json-params)
      (json/wrap-json-response)))