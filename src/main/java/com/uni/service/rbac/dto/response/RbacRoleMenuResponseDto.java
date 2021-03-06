package com.uni.service.rbac.dto.response;

import org.springframework.hateoas.server.core.Relation;

import com.uni.framework.crud.base.dto.BaseResponseDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *  RbacRoleMenu generated by auto
 * 这是类的注释
 *
 * @author lait
 * Created On 2020-10-04.
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "resources")
public class RbacRoleMenuResponseDto extends BaseResponseDto {

    private static final long serialVersionUID = -1L;

    /**
     * TODO 字段信息描述
     */
    private String roleId;

    /**
     * TODO 字段信息描述
     */
    private String menuId;

}
