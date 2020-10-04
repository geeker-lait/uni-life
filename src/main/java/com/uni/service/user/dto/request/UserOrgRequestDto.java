package com.uni.service.user.dto.request;

import com.uni.framework.crud.base.dto.BaseRequestDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *  UserOrg Dto generated by auto
 * 这是类的注释
 *
 * @author lait
 * Created On 2020-10-04.
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class UserOrgRequestDto extends BaseRequestDto {

    private static final long serialVersionUID = -1L;

    /**
     * TODO 字段信息描述
     */
    private String uid;

    /**
     * TODO 字段信息描述
     */
    private String groupId;

    /**
     * TODO 字段信息描述
     */
    private String postId;

    /**
     * TODO 字段信息描述
     */
    private String groupName;

    /**
     * TODO 字段信息描述
     */
    private String postName;

}
