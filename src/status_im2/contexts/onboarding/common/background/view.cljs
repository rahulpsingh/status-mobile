(ns status-im2.contexts.onboarding.common.background.view
  (:require [react-native.core :as rn]
            [react-native.blur :as blur]
            [status-im2.contexts.onboarding.common.carousel.view :as carousel]
            [status-im2.contexts.onboarding.common.background.style :as style]
            [status-im2.contexts.onboarding.common.carousel.animation :as carousel.animation]))

(defn view
  [dark-overlay?]
  [:f>
   (fn []
     (let [animate? (not dark-overlay?)]
       (when animate? (carousel.animation/initialize-animation))
       [rn/view
        {:style style/background-container}
        [carousel/view animate?]
        (when dark-overlay?
          [blur/view
           {:style         style/background-blur-overlay
            :blur-amount   30
            :blur-radius   25
            :blur-type     :transparent
            :overlay-color :transparent}])]))])
