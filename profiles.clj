{:provided {:dependencies [[org.clojure/clojure _]]}
 :dev {:plugins [[lein-pallet-release "RELEASE"]
                 [lein-modules "0.2.4"]]
       :modules {:versions {org.clojure/clojure "1.5.1"}
                 :subprocess false}
       :pallet-release
       {:url "https://pbors:${GH_TOKEN}@github.com/pallet/test-env.git",
        :branch "master"}}
 :no-checkouts {:checkout-deps-shares ^{:replace true} []},
 :release {:set-version {:updates [{:path "README.md",
                                    :no-snapshot true}]}}}
