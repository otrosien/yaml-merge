package com.epages.yaml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;

public class YamlMapper {

    private static final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

    public JsonNode read(File file) throws IOException {
        return mapper.readTree(file);
    }

    public JsonNode read(InputStream stream) throws IOException {
        return mapper.readTree(stream);
    }

    public JsonNode read(String stringInput) throws IOException {
        return mapper.readTree(stringInput);
    }

    public void write(YAMLGenerator generator, JsonNode merged) throws JsonProcessingException, IOException {
        mapper.writeTree(generator, merged);
    }
}
