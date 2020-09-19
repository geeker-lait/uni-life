package com.uni.framework.crud.generator.metadata;

/**
 * 默认的实体解析器
 *
 */
public abstract class BaseEntityParser implements IEntityParser {

    @Override
    public final EntityInfo parse(Class<?> clazz) {
        EntityInfo entityInfo = parseEntity(clazz);
        entityInfo.setFields(parseField(clazz));
        entityInfo.setId(parseId(clazz));
        return entityInfo;
    }

    /**
     * 解析实体信息
     *
     * @param clazz 指定实体类
     * @return 实体信息
     */
    public abstract EntityInfo parseEntity(Class<?> clazz);

    /**
     * 解析主键信息
     *
     * @param clazz 指定实体类
     * @return 主键信息
     */
    public abstract IdInfo parseId(Class<?> clazz);

}
