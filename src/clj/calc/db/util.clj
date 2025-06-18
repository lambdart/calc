(ns calc.db.util
  (:import (java.util UUID)))

(defn uuid
  "Generate an random UUID value"
  []
  (UUID/randomUUID))
