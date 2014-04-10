{:dev {:modules {:parent "../project.clj"
                 :subprocess false}
       :plugins [[lein-modules "0.2.1"]]}
 :no-checkouts {:checkout-deps-shares ^{:replace true} []}
 :release {:set-version {:updates [{:path "README.md"
                                    :no-snapshot true}]}}}
