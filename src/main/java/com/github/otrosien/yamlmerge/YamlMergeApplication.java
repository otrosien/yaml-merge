package com.github.otrosien.yamlmerge;

import java.io.IOException;

import org.apache.commons.cli.ParseException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class YamlMergeApplication {

    public static void main(String[] args) throws IOException {
        try {
            CommandLineArguments arguments = new YamlCommandLineParser().parseCommandLine(args);
            arguments.validate();
            YamlMapper mapper = new YamlMapper();
            JsonNode merged = new YamlMerger().merge(
                    mapper.read(arguments.source()),
                    mapper.read(arguments.override())
            );
            mapper.write(new YAMLFactory().createGenerator(System.out), merged);
        } catch (ParseException e) { // printing help is handled inside YamlCommandLineParser
            System.exit(1);
        }
    }
}
