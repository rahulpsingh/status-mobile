(ns quo2.components.avatars.group-avatar
  (:require [quo2.foundations.colors :as colors]
            [quo2.components.icon :as icon]
            [react-native.core :as rn]))

(def sizes
  {:icon {:small 12
          :medium 16
          :large 20}
   :container {:small 20
               :medium 32
               :large 48}})

(defn group-avatar [_]
  (fn [{:keys [color size override-theme]}]
    (let [theme          (or override-theme (if (colors/dark?) :dark :light))
          container-size (get-in sizes [:container size])
          icon-size      (get-in sizes [:icon size])]
      [rn/view {:width            container-size
                :height           container-size
                :align-items      :center
                :justify-content  :center
                :border-radius    (/ container-size 2)
                :background-color (if (= theme :light)
                                    (colors/custom-color color 50)
                                    (colors/custom-color color 60))}
       [icon/icon :total-members {:size icon-size
                                  :color colors/white-opa-70}]])))
