package com.epages;

import java.io.File;
import java.io.FileNotFoundException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class YamlCommandLineParser {

    private static final String INPUT_SHORT = "i";
    private static final String INPUT_LONG = "input";
    private static final String OVERRIDE_SHORT = "o";
    private static final String OVERRIDE_LONG = "override";

    public CommandLineArguments parseCommandLine(String[] args) throws FileNotFoundException {
        Options options = new Options();

        Option input = new Option(INPUT_SHORT, INPUT_LONG, true, "input yaml file");
        input.setRequired(true);
        options.addOption(input);

        Option override = new Option(OVERRIDE_SHORT, OVERRIDE_LONG, true, "override yaml file");
        override.setRequired(true);
        options.addOption(override);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();

        try {
            CommandLine cmd = parser.parse(options, args);
            String inputFile = cmd.getOptionValue(INPUT_LONG);
            String overrideFile = cmd.getOptionValue(OVERRIDE_LONG);

            return new CommandLineArguments(new File(inputFile), new File(overrideFile));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("yaml-merge", options);

            System.exit(1);
        }
        return null;
    }

}
