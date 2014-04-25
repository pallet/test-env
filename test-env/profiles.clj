{:dev {:dependencies [[ch.qos.logback/logback-classic "1.0.9"]
                      [com.palletops/pallet-docker "0.1.1-SNAPSHOT"]
                      [com.palletops/pallet-aws "0.2.3"]
                      [ch.qos.logback/logback-classic "1.1.1"]
                      [org.slf4j/jcl-over-slf4j "1.7.6"]]
       :plugins [[lein-modules "0.2.4"]]
       :modules {:subprocess false}}
 :provided {:dependencies [[com.palletops/pallet "0.8.0-RC.9"
                            :exclusions [org.clojure/clojure]]
                           ;; [org.clojure/clojure "1.5.1"]
                           ]}
 :no-checkouts {:checkout-deps-shares ^{:replace true} []}
 :release {:set-version {:updates [{:path "README.md"
                                    :no-snapshot true}]}}}
