package com.uni.service.user.dto.search;

import java.util.Map;

import com.uni.framework.crud.base.dto.BaseSearchDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *  UserRelationship Dto generated by auto
 * 这是类的注释
 *
 * @author lait
 * Created On 2020-10-04.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserRelationshipSearchDto extends BaseSearchDto{


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

    /**
     * 实现父类的查询条件过滤
     *
     */
    @Override
    public void buildSearchParams(Map<String, Object> map) {
        super.putNoNull("EQ_pid", this.pid, map);
        super.putNoNull("EQ_org", this.org, map);
        super.putNoNull("EQ_deep", this.deep, map);
        super.putNoNull("EQ_seq", this.seq, map);
        super.putNoNull("EQ_fromUid", this.fromUid, map);
        super.putNoNull("EQ_fromUserName", this.fromUserName, map);
        super.putNoNull("EQ_fromUserPhone", this.fromUserPhone, map);
        super.putNoNull("EQ_toUid", this.toUid, map);
        super.putNoNull("EQ_toUserPhone", this.toUserPhone, map);
        super.putNoNull("EQ_toUserName", this.toUserName, map);
    }

}
