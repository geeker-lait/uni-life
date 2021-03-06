package com.uni.life.generator.jpa.metadata;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 字段信息
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class FieldInfo extends BaseClassInfo {

    /**
     * 字段名称
     */
    private String name;

    /**
     * 字段上的注解
     */
    private List<AnnotationInfo> annotations;

    /**
     * 字段在数据库的注释
     */
    private String comment;

    /**
     * 字段在数据库的字段名
     */
    private String columnName;

}
