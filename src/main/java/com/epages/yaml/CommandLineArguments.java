package com.epages.yaml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UncheckedIOException;
import java.util.stream.Stream;

class CommandLineArguments {

    private final File input;
    private final File override;

    public CommandLineArguments(File input, File override) {
        this.input = input;
        this.override = override;
    }

    public File getInput() {
        return input;
    }

    public File getOverride() {
        return override;
    }

    public void validate() {
        Stream.of(input, override)
        .filter(file -> !file.exists())
        .forEach(file -> {
            throw new UncheckedIOException(new FileNotFoundException(file.getName()));
        });
    }
}