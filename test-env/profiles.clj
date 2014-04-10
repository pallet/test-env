{:dev {:dependencies [[ch.qos.logback/logback-classic "1.0.9"]]
       :plugins [[lein-modules "0.2.1"]]
       :modules {:parent "../project.clj"}}
 :provided {:dependencies [[com.palletops/pallet "0.8.0-RC.9"]]}
 :no-checkouts {:checkout-deps-shares ^{:replace true} []}
 :release {:set-version {:updates [{:path "README.md"
                                    :no-snapshot true}]}}}
