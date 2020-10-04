package com.uni.service.rbac.dto.search;

import java.util.Map;

import com.uni.framework.crud.base.dto.BaseSearchDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *  RbacGroup Dto generated by auto
 * 这是类的注释
 *
 * @author lait
 * Created On 2020-10-04.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RbacGroupSearchDto extends BaseSearchDto{


    /**
     * TODO 字段信息描述
     */
    private String groupPid;

    /**
     * TODO 字段信息描述
     */
    private String groupCode;

    /**
     * TODO 字段信息描述
     */
    private String groupName;

    /**
     * TODO 字段信息描述
     */
    private String groupIcon;

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
        super.putNoNull("EQ_groupPid", this.groupPid, map);
        super.putNoNull("EQ_groupCode", this.groupCode, map);
        super.putNoNull("EQ_groupName", this.groupName, map);
        super.putNoNull("EQ_groupIcon", this.groupIcon, map);
        super.putNoNull("EQ_sorted", this.sorted, map);
    }

}
