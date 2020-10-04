package com.uni.service.rbac.dto.request;

import com.uni.framework.crud.base.dto.BaseRequestDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *  RbacRoleResource Dto generated by auto
 * 这是类的注释
 *
 * @author lait
 * Created On 2020-10-04.
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class RbacRoleResourceRequestDto extends BaseRequestDto {

    private static final long serialVersionUID = -1L;

    /**
     * TODO 字段信息描述
     */
    private String roleId;

    /**
     * TODO 字段信息描述
     */
    private String resourceId;

}
