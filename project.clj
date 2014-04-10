(defproject com.palletops/pallet-test-env "0.1.1-SNAPSHOT"
  :description "Test environment for pallet tests"
  :url "https://github.com/pallet/test-env"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :scm {:url "git@github.com:pallet/pallet.git"}
  :dependencies [[org.clojure/clojure "1.5.1" :scope "provided"]
                 [com.palletops/pallet "0.8.0-RC.9" :scope "provided"]
                 [com.palletops/multi-test "0.1.0"]
                 [clj-time "0.6.0"]])
