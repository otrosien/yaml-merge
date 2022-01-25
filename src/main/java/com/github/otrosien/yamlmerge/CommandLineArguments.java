package com.github.otrosien.yamlmerge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UncheckedIOException;
import java.util.stream.Stream;

record CommandLineArguments(File source, File override) {

    public void validate() {
        Stream.of(source, override)
                .filter(file -> !file.exists())
                .forEach(file -> {
                    throw new UncheckedIOException(new FileNotFoundException(file.getName()));
                });
    }
}