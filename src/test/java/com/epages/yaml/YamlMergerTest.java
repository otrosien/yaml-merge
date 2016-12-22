package com.epages.yaml;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;

public class YamlMergerTest {

    @Test
    public void should_merge_two_yaml() throws Exception {
        JsonNode node1  = new YamlMapper().read(getClass().getResourceAsStream("/com/epages/yaml/simple/input.yaml"));
        JsonNode node2  = new YamlMapper().read(getClass().getResourceAsStream("/com/epages/yaml/simple/override.yaml"));
        JsonNode expected  = new YamlMapper().read(getClass().getResourceAsStream("/com/epages/yaml/simple/expected.yaml"));
        JsonNode merged = new YamlMerger().merge(node1, node2);
        assertEquals(expected, merged);
    }

    @Test
    public void should_merge_textnode_yaml() throws Exception {
        JsonNode node1  = new YamlMapper().read(getClass().getResourceAsStream("/com/epages/yaml/textnode/input.yaml"));
        JsonNode node2  = new YamlMapper().read(getClass().getResourceAsStream("/com/epages/yaml/textnode/override.yaml"));
        JsonNode expected  = new YamlMapper().read(getClass().getResourceAsStream("/com/epages/yaml/textnode/expected.yaml"));
        JsonNode merged = new YamlMerger().merge(node1, node2);
        assertEquals(expected, merged);
    }
}
