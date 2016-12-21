package com.epages;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;

public class YamlMapper {

    private static final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

    public JsonNode read(File file) throws JsonProcessingException, IOException {
        return mapper.readTree(file);
    }

    public void write(YAMLGenerator generator, JsonNode merged) throws JsonProcessingException, IOException {
        mapper.writeTree(generator, merged);
    }
}
