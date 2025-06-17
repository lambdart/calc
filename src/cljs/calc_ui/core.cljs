(ns calc-ui.core
  (:require [reagent.dom.client :as rdc]
            [re-frame.core :as rf]
            [calc-ui.views :as views]
            [calc-ui.config :as config]
            [calc-ui.events :as events]))

(defonce root-container
  (rdc/create-root (js/document.getElementById "app")))

(defn mount-ui
  []
  (rdc/render root-container [views/main-panel]))

(defn ^:dev/after-load clear-cache-and-render!
  []
  ;; The `:dev/after-load` metadata causes this function to be called
  ;; after shadow-cljs hot-reloads code. We force a UI update by clearing
  ;; the Reframe subscription cache.
  (rf/clear-subscription-cache!)
  (mount-ui))

(defn run []
  (rf/dispatch-sync [::events/initialize])
  (mount-ui))

(defn ^:export main
  []
  (run))
