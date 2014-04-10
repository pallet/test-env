{:dev {:dependencies [[ch.qos.logback/logback-classic "1.0.9"]]
       :plugins [[lein-pallet-release "RELEASE"]],
       :pallet-release
       {:url "https://pbors:${GH_TOKEN}@github.com/pallet/test-env.git",
        :branch "master"}},
 :no-checkouts {:checkout-deps-shares ^{:replace true} []},
 :release {:set-version {:updates [{:path "README.md",
                                    :no-snapshot true}]}}}
