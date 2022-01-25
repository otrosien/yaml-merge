package com.github.otrosien.yamlmerge;

import java.io.File;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class YamlCommandLineParser {

    private static final String SOURCE_SHORT = "s";
    private static final String SOURCE_LONG = "source";
    private static final String OVERRIDE_SHORT = "o";
    private static final String OVERRIDE_LONG = "override";

    public CommandLineArguments parseCommandLine(String[] args) throws ParseException {
        Options options = new Options();

        Option source = new Option(SOURCE_SHORT, SOURCE_LONG, true, "source yaml file");
        source.setRequired(true);
        options.addOption(source);

        Option override = new Option(OVERRIDE_SHORT, OVERRIDE_LONG, true, "override yaml file");
        override.setRequired(true);
        options.addOption(override);

        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse(options, args);
            String sourceFile   = cmd.getOptionValue(SOURCE_LONG);
            String overrideFile = cmd.getOptionValue(OVERRIDE_LONG);

            return new CommandLineArguments(new File(sourceFile), new File(overrideFile));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            new HelpFormatter().printHelp("yaml-merge", options);
            throw e;
        }
    }

}
