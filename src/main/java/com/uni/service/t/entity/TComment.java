package com.uni.service.t.entity;

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
@Table(name = "t_comment")
@EqualsAndHashCode(callSuper = false)
public class TComment extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = -1L;

    /**
     * TODO 
     */
    //@Column(name = "comment_id")
    private Integer commentId;

    /**
     * TODO 
     */
    //@Column(name = "user_id")
    private String userId;

    /**
     * TODO 
     */
    //@Column(name = "comment_parent_id")
    private Integer commentParentId;

    /**
     * TODO 
     */
    //@Column(name = "comment_content")
    private String commentContent;

    /**
     * TODO 
     */
    //@Column(name = "comment_state")
    private Integer commentState;

    /**
     * TODO 
     */
    //@Column(name = "news_id")
    private Integer newsId;

    /**
     * TODO 
     */
    //@Column(name = "create_time")
    private LocalDateTime createTime;

}
