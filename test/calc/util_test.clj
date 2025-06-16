(ns calc.util-test
  (:require [calc.util :as util]
            [clojure.data.json :as json]
            [clojure.test :refer [deftest testing is]]))

(deftest transform-body-test
  (testing "Transform body test."
    (let [result (-> {:test 'test}
                     (util/transform-body "application/json"))]
      (is (string? result)
          (= result "{\"test\":\"test\"}")))))
