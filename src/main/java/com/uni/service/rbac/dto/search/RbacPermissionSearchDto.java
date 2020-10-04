package com.uni.service.rbac.dto.search;

import java.util.Map;

import com.uni.framework.crud.base.dto.BaseSearchDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *  RbacPermission Dto generated by auto
 * 这是类的注释
 *
 * @author lait
 * Created On 2020-10-04.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RbacPermissionSearchDto extends BaseSearchDto{


    /**
     * TODO 字段信息描述
     */
    private String permissionCode;

    /**
     * TODO 字段信息描述
     */
    private String permissionName;

    /**
     * TODO 字段信息描述
     */
    private String permissionVal;

    /**
     * TODO 字段信息描述
     */
    private String permissionUri;

    /**
     * TODO 字段信息描述
     */
    private String permissionTyp;

    /**
     * TODO 字段信息描述
     */
    private Integer sorted;

    /**
     * 实现父类的查询条件过滤
     *
     */
    @Override
    public void buildSearchParams(Map<String, Object> map) {
        super.putNoNull("EQ_permissionCode", this.permissionCode, map);
        super.putNoNull("EQ_permissionName", this.permissionName, map);
        super.putNoNull("EQ_permissionVal", this.permissionVal, map);
        super.putNoNull("EQ_permissionUri", this.permissionUri, map);
        super.putNoNull("EQ_permissionTyp", this.permissionTyp, map);
        super.putNoNull("EQ_sorted", this.sorted, map);
    }

}
