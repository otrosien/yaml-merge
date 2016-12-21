package com.epages;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

// http://stackoverflow.com/a/32447591
public class YamlMergeApplication {

    public static void main(String[] args) throws Exception {
        CommandLineArguments arguments = new YamlCommandLineParser().parseCommandLine(args);
        YamlMapper mapper = new YamlMapper();
        JsonNode merged = new YamlMerger().merge(
                mapper.read(arguments.getInput()),
                mapper.read(arguments.getOverride())
        );
        mapper.write(new YAMLFactory().createGenerator(System.out), merged);
    }
}
