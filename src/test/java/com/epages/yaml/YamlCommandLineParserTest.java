package com.epages.yaml;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.UncheckedIOException;

import org.junit.Test;

public class YamlCommandLineParserTest {

    @Test
    public void test_parse_short() throws Exception {
        CommandLineArguments args = new YamlCommandLineParser().parseCommandLine(new String[] {"-s", "file1", "-o", "file2"});
        assertThat(args.getSource()).isEqualTo(new File("file1"));
        assertThat(args.getOverride()).isEqualTo(new File("file2"));
    }

    @Test
    public void test_parse_long() throws Exception {
        CommandLineArguments args = new YamlCommandLineParser().parseCommandLine(new String[] {"--source", "file1", "--override", "file2"});
        assertThat(args.getSource()).isEqualTo(new File("file1"));
        assertThat(args.getOverride()).isEqualTo(new File("file2"));
    }

    @Test(expected=UncheckedIOException.class)
    public void test_validate_invalid_files() throws Exception {
        CommandLineArguments args = new YamlCommandLineParser().parseCommandLine(new String[] {"-s", "file1", "-o", "file2"});
        args.validate();
    }

    @Test
    public void test_validate_valid_files() throws Exception {
        // just need a valid File reference.
        CommandLineArguments args = new YamlCommandLineParser().parseCommandLine(new String[] { "-s",
                System.getProperty("java.io.tmpdir"), "-o", System.getProperty("java.io.tmpdir") });
        args.validate();
    }

}
