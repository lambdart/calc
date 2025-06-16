(ns calc.handler-test
  (:require [calc.handler :as handler]
            [clojure.data.json :as json]
            [clojure.test :refer [deftest testing is]]))

(deftest increment-test
  (testing "Increment handler test."
    (let [result (handler/increment {})]
      (is (= (:body result) {:increment 1})))))

(deftest reset-test
  (testing "Reset handler test."
    (let [result (handler/reset {})]
      (is (= (:body result) {:reset 0})))))

