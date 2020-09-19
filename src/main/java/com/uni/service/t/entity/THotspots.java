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
@Table(name = "t_hotspots")
@EqualsAndHashCode(callSuper = false)
public class THotspots extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = -1L;

    /**
     * TODO df 
     */
    //@Column(name = "hotspots_id")
    private Integer hotspotsId;

    /**
     * TODO fdsf  
     */
    //@Column(name = "news_id")
    private Integer newsId;

    /**
     * TODO 
     */
    //@Column(name = "news_score")
    private String newsScore;

    /**
     * TODO 
     */
    //@Column(name = "news_publishTime")
    private LocalDateTime newsPublishtime;

    /**
     * TODO 
     */
    //@Column(name = "update_time")
    private LocalDateTime updateTime;

}
