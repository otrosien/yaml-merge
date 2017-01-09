package com.epages.yaml;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.StringWriter;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class YamlMapperTest {

    @Test
    public void test_roundtrip() throws Exception {
        JsonNode node1  = new YamlMapper().read(getClass().getResourceAsStream("/com/epages/yaml/simple/input.yaml"));
        YamlMapper mapper = new YamlMapper();
        StringWriter writer = new StringWriter();
        mapper.write(new YAMLFactory().createGenerator(writer), node1);
        assertThat(new YamlMapper().read(writer.toString())).isEqualTo(node1);
    }

}
