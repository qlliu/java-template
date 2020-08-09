package com.doublefs.common.javatemplate.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * @author liuqingliang
 */
@Component
public class JacksonUtil {

    private static ObjectMapper objectMapper;

    @Resource
    public void setJacksonObjectMapper(ObjectMapper jacksonObjectMapper) {
        objectMapper = jacksonObjectMapper;
    }

    public static ObjectMapper getInstance() {
        return objectMapper;
    }

    public static JsonNodeFactory getJsonNodeFactory() {
        return objectMapper.getNodeFactory();
    }

    /**
     * 获取ObjectNode
     */
    public static ObjectNode getObjectNode() {
        return objectMapper.createObjectNode();
    }

    /**
     * 获取ArrayNode
     */
    public static ArrayNode getArrayNode() {
        return objectMapper.createArrayNode();
    }

    /**
     * 获取ArrayNode
     */
    public static ArrayNode getArrayNode(List list) {
        ArrayNode arrayNode = JacksonUtil.getJsonNodeFactory().arrayNode();
        list.stream().forEach(t -> {
            if (t instanceof Integer) {
                arrayNode.add((Integer) t);
            } else if (t instanceof String) {
                arrayNode.add((String) t);
            }
        });
        return arrayNode;
    }

    /**
     * 获取Tree Model
     */
    public static JsonNode readTree(String content) {
        try {
            if (content == null) {
                return null;
            }
            return objectMapper.readTree(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取Tree Model
     */
    public static JsonNode readTree(Object object) {
        try {
            if (Objects.isNull(object)) {
                return null;
            }
            String content = JacksonUtil.write(object);
            if (content == null) {
                return null;
            }
            return objectMapper.readTree(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 转换为 JSON 字符串
     */
    public static String write(Object obj) {
        try {
            if (obj == null) {
                return null;
            }
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 转换为 JavaBean
     */
    public static <T> T read(String jsonString, Class<T> clazz) {
        try {
            if (jsonString == null) {
                return null;
            }
            return objectMapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 转换为 JavaBean
     */
    public static <T> T read(String jsonString, TypeReference<T> valueTypeRef) {
        try {
            if (jsonString == null) {
                return null;
            }
            return objectMapper.readValue(jsonString, valueTypeRef);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
