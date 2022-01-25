package com.github.otrosien.yamlmerge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;

public class YamlMergerTest {

    @Test
    public void should_merge_two_yaml() throws Exception {
        JsonNode node1  = new YamlMapper().read(getClass().getResourceAsStream("/com/github/otrosien/yamlmerge/simple/input.yaml"));
        JsonNode node2  = new YamlMapper().read(getClass().getResourceAsStream("/com/github/otrosien/yamlmerge/simple/override.yaml"));
        JsonNode expected  = new YamlMapper().read(getClass().getResourceAsStream("/com/github/otrosien/yamlmerge/simple/expected.yaml"));
        JsonNode merged = new YamlMerger().merge(node1, node2);
        assertThat(merged).isEqualTo(expected);
    }

    @Test
    public void should_merge_textnode_yaml() throws Exception {
        JsonNode node1  = new YamlMapper().read(getClass().getResourceAsStream("/com/github/otrosien/yamlmerge/textnode/input.yaml"));
        JsonNode node2  = new YamlMapper().read(getClass().getResourceAsStream("/com/github/otrosien/yamlmerge/textnode/override.yaml"));
        JsonNode expected  = new YamlMapper().read(getClass().getResourceAsStream("/com/github/otrosien/yamlmerge/textnode/expected.yaml"));
        JsonNode merged = new YamlMerger().merge(node1, node2);
        assertThat(merged).isEqualTo(expected);
    }

    @Test
    public void should_merge_nestedarray_yaml() throws Exception {
        JsonNode node1  = new YamlMapper().read(getClass().getResourceAsStream("/com/github/otrosien/yamlmerge/nestedarrays/input.yaml"));
        JsonNode node2  = new YamlMapper().read(getClass().getResourceAsStream("/com/github/otrosien/yamlmerge/nestedarrays/override.yaml"));
        JsonNode expected  = new YamlMapper().read(getClass().getResourceAsStream("/com/github/otrosien/yamlmerge/nestedarrays/expected.yaml"));
        JsonNode merged = new YamlMerger().merge(node1, node2);
        assertThat(merged).isEqualTo(expected);
    }

    @Test
    public void should_merge_with_replacement() throws Exception {
        JsonNode node1  = new YamlMapper().read(getClass().getResourceAsStream("/com/github/otrosien/yamlmerge/replace/input.yaml"));
        JsonNode node2  = new YamlMapper().read(getClass().getResourceAsStream("/com/github/otrosien/yamlmerge/replace/override.yaml"));
        JsonNode expected  = new YamlMapper().read(getClass().getResourceAsStream("/com/github/otrosien/yamlmerge/replace/expected.yaml"));
        JsonNode merged = new YamlMerger().merge(node1, node2);
        assertThat(merged).isEqualTo(expected);
    }
}
