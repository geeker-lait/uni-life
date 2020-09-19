package com.uni.service.rbac.dto.response;

import org.springframework.hateoas.server.core.Relation;

import com.uni.framework.crud.base.dto.BaseResponseDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *  RbacPermission generated by auto
 * 这是类的注释
 *
 * @author lait
 * Created On 2020-09-17.
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "resources")
public class RbacPermissionResponseDto extends BaseResponseDto {

    /**
     *
     */
    private static final long serialVersionUID = -1L;

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

}