package com.epages;

import java.io.File;
import java.io.FileNotFoundException;

class CommandLineArguments {

    final File input;
    final File override;

    public CommandLineArguments(File input, File override) throws FileNotFoundException {
        this.input = input;
        this.override = override;
        validate();
    }

    public File getInput() {
        return input;
    }

    public File getOverride() {
        return override;
    }

    void validate() throws FileNotFoundException {
        if(! input.exists()) {
            throw new FileNotFoundException(input.getName());
        }
        if(! override.exists()) {
            throw new FileNotFoundException(override.getName());
        }
    }
}