package com.github.otrosien.yamlmerge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UncheckedIOException;
import java.util.stream.Stream;

class CommandLineArguments {

    private final File source;
    private final File override;

    public CommandLineArguments(File source, File override) {
        this.source = source;
        this.override = override;
    }

    public File getSource() {
        return source;
    }

    public File getOverride() {
        return override;
    }

    public void validate() {
        Stream.of(source, override)
        .filter(file -> !file.exists())
        .forEach(file -> {
            throw new UncheckedIOException(new FileNotFoundException(file.getName()));
        });
    }
}