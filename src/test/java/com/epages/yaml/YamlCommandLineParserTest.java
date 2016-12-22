package com.epages.yaml;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.UncheckedIOException;

import org.junit.Test;

public class YamlCommandLineParserTest {

    @Test
    public void test_parse_short() throws Exception {
        CommandLineArguments args = new YamlCommandLineParser().parseCommandLine(new String[] {"-i", "file1", "-o", "file2"});
        assertEquals(args.getInput(), new File("file1"));
        assertEquals(args.getOverride(), new File("file2"));
    }

    @Test
    public void test_parse_long() throws Exception {
        CommandLineArguments args = new YamlCommandLineParser().parseCommandLine(new String[] {"--input", "file1", "--override", "file2"});
        assertEquals(args.getInput(), new File("file1"));
        assertEquals(args.getOverride(), new File("file2"));
    }

    @Test(expected=UncheckedIOException.class)
    public void test_validate_invalid_files() throws Exception {
        CommandLineArguments args = new YamlCommandLineParser().parseCommandLine(new String[] {"-i", "file1", "-o", "file2"});
        args.validate();
    }

    @Test
    public void test_validate_valid_files() throws Exception {
        // just need a valid File reference.
        CommandLineArguments args = new YamlCommandLineParser().parseCommandLine(new String[] { "-i",
                System.getProperty("java.io.tmpdir"), "-o", System.getProperty("java.io.tmpdir") });
        args.validate();
    }

}
