(defproject com.palletops/pallet-test-env "0.1.2-SNAPSHOT"
  :description "Test environment for pallet tests"
  :url "https://github.com/pallet/test-env"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :scm {:url "git@github.com:pallet/pallet.git"}
  :dependencies [[com.palletops/multi-test "0.1.0"]
                 [com.palletops/crates "RELEASE"]
                 [clj-time "0.6.0"]]
  :parent [com.palletops/pallet-test-env-parent _ :relative-path "../pom.xml"])
