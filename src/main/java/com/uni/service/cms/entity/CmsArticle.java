package com.uni.service.cms.entity;

import com.uni.framework.crud.base.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * 这是类的注释
 *
 * @author lait
 * Created On 2020-08-26.
 */
@Data
@Entity
@Table(name = "cms_article")
@EqualsAndHashCode(callSuper = false)
public class CmsArticle extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = -1L;

    /**
     * TODO 所属栏目ID
     */
    //@Column(name = "category_id")
    private String categoryId;

    /**
     * TODO 文章ID
     */
    //@Column(name = "article_id")
    private String articleId;

    /**
     * TODO 分类ID
     */
    //@Column(name = "group_id")
    private String groupId;

    /**
     * TODO 
     */
    //@Column(name = "account_id")
    private String accountId;

    /**
     * TODO 类型
     */
    //@Column(name = "group_name")
    private String groupName;

    /**
     * TODO 
     */
    //@Column(name = "account_name")
    private String accountName;

    /**
     * TODO 标题
     */
    //@Column(name = "title")
    private String title;

    /**
     * TODO 简介
     */
    //@Column(name = "summary")
    private String summary;

    /**
     * TODO 内容
     */
    //@Column(name = "content")
    private String content;

    /**
     * TODO 
     */
    //@Column(name = "descr")
    private String descr;

    /**
     * TODO 人气
     */
    //@Column(name = "href")
    private String href;

    /**
     * TODO 
     */
    //@Column(name = "pubtime")
    private String pubtime;

    /**
     * TODO 状态
     */
    //@Column(name = "state")
    private Integer state;

    /**
     * TODO 创建时间
     */
    //@Column(name = "create_time")
    private String createTime;

}
