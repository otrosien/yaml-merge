# yaml-merge

Merges two YAML files and writes the result to STDOUT. Merging of Array nodes is implemented by merging array contents based on the same array index.

```
usage: yaml-merge
 -i,--input <arg>      input yaml file
 -o,--override <arg>   override yaml file
```

## Installation

Create a distribution zip and extract it into a local directory.

```
./gradlew distZip
mkdir ~/yaml-merge
unzip -o -d ~/yaml-merge build/distributions/yaml-merge-0.1.2.zip
PATH=$PATH:~/yaml-merge/yaml-merge-0.1.2/bin
```


