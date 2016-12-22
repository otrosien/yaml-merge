package com.epages.yaml;

import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

public class YamlMerger {

    // solution based on: http://stackoverflow.com/a/32447591, but adapted
    // to merge two arrays nodes.
    public JsonNode merge(JsonNode mainNode, JsonNode updateNode) {

        Iterator<String> fieldNames = updateNode.fieldNames();

        while (fieldNames.hasNext()) {
            String updatedFieldName = fieldNames.next();
            JsonNode valueToBeUpdated = mainNode.get(updatedFieldName);
            JsonNode updatedValue = updateNode.get(updatedFieldName);

            // If the node is an @ArrayNode -> only adds elements
            if (valueToBeUpdated != null && valueToBeUpdated.isArray() && 
                updatedValue.isArray()) {
                ((ArrayNode) valueToBeUpdated).addAll((ArrayNode)updatedValue);
            // if the Node is an @ObjectNode
            } else if (valueToBeUpdated != null && valueToBeUpdated.isObject()) {
                merge(valueToBeUpdated, updatedValue);
            } else {
                ((ObjectNode) mainNode).replace(updatedFieldName, updatedValue);
            }
        }
        if (updateNode instanceof TextNode) {
            return updateNode;
        }
        return mainNode;
    }

}
