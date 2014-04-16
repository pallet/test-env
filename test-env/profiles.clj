{:dev {:dependencies [[ch.qos.logback/logback-classic "1.0.9"]]
       :plugins [[lein-modules "0.2.4"]]
       :modules {:subprocess false}}
 :provided {:dependencies [[com.palletops/pallet "0.8.0-RC.9"
                            :exclusions [org.clojure/clojure]]]}
 :no-checkouts {:checkout-deps-shares ^{:replace true} []}
 :release {:set-version {:updates [{:path "README.md"
                                    :no-snapshot true}]}}}
