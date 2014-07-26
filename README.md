# android-localization-values-folders

A Clojure library designed to create values-de, values-en... folders.

## Requirements

* Leiningen
* Java

## Usage

1. Modify resources/languages.txt and add the country code languages you want to create a values- folder for.

#### As a jar w/ dependencies

2. lein jar
3. cd project home
3. java -cp “.:target/gen-0.1.0.jar:PATH_TO_CLOJURE_JAR” gen.values

#### Standalone jar

2. lein uberjar
3. java -jar gen-0.1.0.jar

#### Total Leindomination

2. lein run

### Finished! Copy to your android project.

## Improvements
* Automate translation
* Rakefile it!
* CLASSPATH maybe for clojure

## License

Copyright © 2014 Steve Wyckoff

Released Released under the MIT license
