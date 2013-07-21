(defproject mtrx9 "0.1.0"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [aleph "0.3.0-rc2"]
                 [compojure "1.1.5"]
                 [ring/ring-jetty-adapter "1.1.6"]
                 [hiccup "1.0.3"]]
  :plugins [[lein-ring "0.8.5"]]
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.5"]]}}
  :main mtrx9.core)
