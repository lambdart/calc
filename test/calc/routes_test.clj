(ns calc.routes-test
  (:require [calc.routes :as router]
            [calc.server :as server]
            [calc.routes-fixture :as routes-fixture]
            [io.pedestal.http :as http]
            [io.pedestal.test :as test]
            [clojure.data.json :as json]
            [clojure.test :refer [deftest testing is use-fixtures]]))

(use-fixtures :once routes-fixture/restart-fixture)

(defn test-request
  "Test the request using the API `verb` and its `url."
  [verb url & options]
  (apply test/response-for
         (::http/service-fn @server/server) verb url options))

(defn body-contains?
  [r k]
  (contains? (json/read-str (:body r)) k))

(deftest increment-test
  (testing "Increment api test."
    (let [result (test-request :get "/v1/increment")]
      (is (= (body-contains? result "increment") true)))))

(deftest reset-test
  (testing "Reset api test."
    (let [result (test-request :get "/v1/reset")]
      (is (= (body-contains? result "reset") true)))))
