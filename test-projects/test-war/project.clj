(defproject lein-package/test-war "2.1.1"
  :description "This project test the usage of the package command when generating only a WAR with the lein-ring plugin.
    To test, perform the following:

      lein package
      lein install
      lein deploy local

    The deploy task will put the artifact(s) in the target/deploy directory."

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]]

  :plugins [[lein-package "2.1.1"]
            [lein-ring "0.8.3"]]

  :hooks [leiningen.package.hooks.deploy
          leiningen.package.hooks.install]

  :ring {:handler lein-package.test-war/handler}

  :package {:skipjar true 
            :autobuild true
            :artifacts [{:build "ring war" :extension "war" }]}

  :deploy-repositories [["local" "file:./target/deploy"]])
