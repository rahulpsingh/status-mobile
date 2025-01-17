(ns status-im2.navigation.screens
  (:require
    [react-native.platform :as platform]
    [status-im2.config :as config]
    [status-im2.contexts.activity-center.view :as activity-center]
    [status-im2.contexts.add-new-contact.views :as add-new-contact]
    [status-im2.contexts.chat.lightbox.view :as lightbox]
    [status-im2.contexts.chat.messages.view :as chat]
    [status-im2.contexts.chat.photo-selector.album-selector.view :as album-selector]
    [status-im2.contexts.chat.photo-selector.view :as photo-selector]
    [status-im2.contexts.communities.discover.view :as communities.discover]
    [status-im2.contexts.communities.overview.view :as communities.overview]
    [status-im2.contexts.onboarding.intro.view :as intro]
    [status-im2.contexts.onboarding.create-password.view :as create-password]
    [status-im2.contexts.onboarding.create-profile.view :as create-profile]
    [status-im2.contexts.onboarding.enable-biometrics.view :as enable-biometrics]
    [status-im2.contexts.onboarding.enable-notifications.view :as enable-notifications]
    [status-im2.contexts.onboarding.welcome.view :as welcome]
    [status-im2.contexts.onboarding.new-to-status.view :as new-to-status]
    [status-im2.contexts.onboarding.sign-in.view :as sign-in]
    [status-im2.contexts.onboarding.syncing.syncing-devices.view :as syncing-devices]
    [status-im2.contexts.onboarding.generating-keys.view :as generating-keys]
    [status-im2.contexts.onboarding.enter-seed-phrase.view :as enter-seed-phrase]
    [status-im2.contexts.onboarding.profiles.view :as profiles]
    [status-im2.contexts.quo-preview.main :as quo.preview]
    [status-im2.contexts.shell.view :as shell]
    [status-im2.contexts.syncing.syncing-devices-list.view :as settings-syncing]
    [status-im2.navigation.options :as options]
    [status-im2.contexts.chat.group-details.view :as group-details]
    [status-im.ui.screens.screens :as old-screens]
    [status-im2.contexts.communities.menus.request-to-join.view :as join-menu]
    [status-im2.contexts.syncing.setup-syncing.view :as settings-setup-syncing]))

(defn screens
  []
  (concat
   (old-screens/screens)

   [{:name      :intro
     :component intro/view}

    {:name      :activity-center
     :options   options/transparent-screen-options
     :component activity-center/view}

    {:name      :shell-stack
     :component shell/shell-stack}

    {:name      :chat
     :options   {:insets {:top? true}}
     :component chat/chat}

    {:name      :group-add-manage-members
     :options   {:sheet? true}
     :component group-details/add-manage-members}

    {:name      :community-requests-to-join
     :options   {:sheet? true}
     :component join-menu/request-to-join}

    {:name      :lightbox
     :options   options/lightbox
     :component lightbox/lightbox}

    {:name      :photo-selector
     :options   {:sheet? true}
     :component photo-selector/photo-selector}

    {:name      :album-selector
     :options   {:modalPresentationStyle (if platform/ios? :overCurrentContext :none)}
     :component album-selector/album-selector}

    {:name      :new-contact
     :options   {:sheet? true}
     :component add-new-contact/new-contact}

    {:name      :discover-communities
     :component communities.discover/discover}

    {:name      :community-overview
     :component communities.overview/overview}

    {:name      :settings-syncing
     :options   (options/statusbar true)
     :component settings-syncing/view}

    {:name      :settings-setup-syncing
     :options   (options/statusbar true)

     :component settings-setup-syncing/view}

    ;; Onboarding
    {:name      :profiles
     :component profiles/views}

    {:name      :new-to-status
     :component new-to-status/new-to-status}

    {:name      :create-profile
     :component create-profile/create-profile}

    {:name      :create-profile-password
     :options   {:insets {:top false}}
     :component create-password/create-password}

    {:name      :enable-biometrics
     :component enable-biometrics/enable-biometrics}

    {:name      :generating-keys
     :options   {:popGesture         false
                 :hardwareBackButton {:dismissModalOnPress false
                                      :popStackOnPress     false}}
     :component generating-keys/generating-keys}

    {:name      :enter-seed-phrase
     :component enter-seed-phrase/enter-seed-phrase}

    {:name      :enable-notifications
     :options   {:popGesture         false
                 :hardwareBackButton {:dismissModalOnPress false
                                      :popStackOnPress     false}}
     :component enable-notifications/enable-notifications}

    {:name      :sign-in
     :component sign-in/view}

    {:name      :syncing-devices
     :component syncing-devices/syncing-devices}

    {:name      :welcome
     :component welcome/view}]

   (when config/quo-preview-enabled?
     quo.preview/screens)

   (when config/quo-preview-enabled?
     quo.preview/main-screens)))
