(ns lein-test-env.plugin
  (:require
   [leiningen.core.project :refer [add-profiles merge-profiles]]
   [leiningen.test-env :refer [test-env-profiles]]
   [configleaf.hooks :as configleaf-hooks]))

(def test-selectors
  '{:test-selectors {:default (complement :support)
                     :support :support
                     :all (constantly true)}})

(def configleaf
  '{:configleaf {:config-source-path "test"
                 :namespace pallet.test-env.project
                 :verbose true}})

(def profiles
  {:jclouds {:dependencies '[[com.palletops/pallet-jclouds "1.7.0-alpha.2"]
                             [org.apache.jclouds.driver/jclouds-slf4j "1.7.1"
                              :exclusions [org.slf4j/slf4j-api]]
                             [org.apache.jclouds.driver/jclouds-sshj "1.7.1"]]
             :pallet/test-env {:service :aws-ec2}}
   :aws {:dependencies '[[com.palletops/pallet-aws "0.2.0"]
                         [ch.qos.logback/logback-classic "1.1.1"]
                         [org.slf4j/jcl-over-slf4j "1.7.6"]]
         :pallet/test-env {:service :ec2}}
   :vmfest {:dependencies '[[com.palletops/pallet-vmfest "0.4.0-alpha.1"]]
            :pallet/test-env {:service :vmfest}}})

(defn deep-merge
  "Recursively merge maps."
  [& ms]
  (letfn [(f [a b]
            (if (and (map? a) (map? b))
              (deep-merge a b)
              b))]
    (apply merge-with f ms)))

(defn merge-project
  [project profile]
  (with-meta
    (merge profile project)
    (meta project)))

(defn middleware
  "Middleware to add test-env profiles, and activate :pallet/test-env."
  [project]
  (->
   project
   (add-profiles (deep-merge profiles (test-env-profiles project)))
   (merge-project (merge configleaf test-selectors))))

(defn hooks
  []
  (configleaf-hooks/activate))
