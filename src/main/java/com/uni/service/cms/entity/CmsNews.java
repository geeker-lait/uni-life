package com.uni.service.cms.entity;

import com.uni.framework.crud.base.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

/**
 *
 * 这是类的注释
 *
 * @author lait
 * Created On 2020-08-26.
 */
@Data
@Entity
@Table(name = "cms_news")
@EqualsAndHashCode(callSuper = false)
public class CmsNews extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = -1L;

    /**
     * TODO 
     */
    //@Column(name = "news_id")
    private Integer newsId;

    /**
     * TODO 
     */
    //@Column(name = "news_title")
    private String newsTitle;

    /**
     * TODO 
     */
    //@Column(name = "news_pic")
    private String newsPic;

    /**
     * TODO 
     */
    //@Column(name = "news_content")
    private String newsContent;

    /**
     * TODO 
     */
    //@Column(name = "news_publishTime")
    private LocalDateTime newsPublishtime;

    /**
     * TODO 
     */
    //@Column(name = "news_readingNumber")
    private Integer newsReadingnumber;

    /**
     * TODO 
     */
    //@Column(name = "news_commentCount")
    private Integer newsCommentcount;

    /**
     * TODO 
     */
    //@Column(name = "category_id")
    private Integer categoryId;

    /**
     * TODO 
     */
    //@Column(name = "user_id")
    private String userId;

    /**
     * TODO 
     */
    //@Column(name = "update_time")
    private LocalDateTime updateTime;

}
