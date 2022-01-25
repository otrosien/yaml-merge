# yaml-merge (GraalVM native build)

Merges two YAML files and writes the result to STDOUT. Merging of Array nodes is implemented by merging array contents based on the same array index.

```
usage: yaml-merge
 -i,--input <arg>      input yaml file
 -o,--override <arg>   override yaml file
```

## Local Installation

Build using GraalVM

```
export JAVA_HOME=$GRAALVM_HOME
./gradlew nativeCompile
cp ./build/native/nativeCompile/yaml-merge /usr/local/bin
```

## Releasing

A new release is initiated by the `axion` release plugin. As a result, GitHub will 
build the tag and upload the release artifact to the release page.

```
./gradlew release
```

