package com.uni.life.generator.jpa.render;

import com.uni.life.generator.jpa.metadata.EntityInfo;
import lombok.Data;

import java.util.Map;
import java.util.Set;

/**
 * 渲染请求
 */
@Data
public class RenderingRequest {
    private String ftlName;
    private String ftlPath;
    private String savePath;
    private String packageName;
    private boolean cover;
    private String className;
    private String author;
    private String date;
    private String comments;
    private EntityInfo entity;
    private Set<String> imports;
    private Map<String, RenderingResponse> lastRenderResponse;
    private Map<String, String> otherParams;
}
