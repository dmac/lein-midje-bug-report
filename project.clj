(defproject lein-midje-bug-report "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [midje "1.8.2"]]
  :plugins [[lein-midje "3.2"]]
  :manifest {"Project-Name" ~#(:group %)})
