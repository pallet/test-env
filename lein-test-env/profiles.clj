{:dev {:modules {:subprocess false}
       :plugins [[lein-modules "0.2.2"]]}
 :no-checkouts {:checkout-deps-shares ^{:replace true} []}
 :release {:set-version {:updates [{:path "README.md"
                                    :no-snapshot true}]}}}
