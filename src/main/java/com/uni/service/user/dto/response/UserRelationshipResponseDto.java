package com.uni.service.user.dto.response;

import org.springframework.hateoas.server.core.Relation;

import com.uni.framework.crud.base.dto.BaseResponseDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *  UserRelationship generated by auto
 * 这是类的注释
 *
 * @author lait
 * Created On 2020-10-04.
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "resources")
public class UserRelationshipResponseDto extends BaseResponseDto {

    private static final long serialVersionUID = -1L;

    /**
     * TODO 字段信息描述
     */
    private String pid;

    /**
     * TODO 字段信息描述
     */
    private Integer org;

    /**
     * TODO 字段信息描述
     */
    private Integer deep;

    /**
     * TODO 字段信息描述
     */
    private Integer seq;

    /**
     * TODO 字段信息描述
     */
    private String fromUid;

    /**
     * TODO 字段信息描述
     */
    private String fromUserName;

    /**
     * TODO 字段信息描述
     */
    private String fromUserPhone;

    /**
     * TODO 字段信息描述
     */
    private String toUid;

    /**
     * TODO 字段信息描述
     */
    private String toUserPhone;

    /**
     * TODO 字段信息描述
     */
    private String toUserName;

}
