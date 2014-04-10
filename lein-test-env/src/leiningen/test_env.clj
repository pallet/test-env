(ns leiningen.test-env)

(defn test-env-profiles
  [project]
  (->> (:profiles (meta project))
       (filter #(contains? (val %) :pallet/test-env))
       (into {})))

(defn test-env
  "Display test-env profiles"
  [project & args]
  (let [ks (keys (test-env-profiles project))]
    (println "To generate test-results.edn, run tests with:")
    (println (str "lein with-profile +"
                  (or (first ks) :your-profile)
                  " test :support"))
    (println)
    (println "test-env available profiles:")
    (doseq [k ks]
      (println "   " k))))
