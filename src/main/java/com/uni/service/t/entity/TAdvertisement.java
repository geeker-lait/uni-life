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
@Table(name = "t_advertisement")
@EqualsAndHashCode(callSuper = false)
public class TAdvertisement extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = -1L;

    /**
     * TODO 
     */
    //@Column(name = "advertisement_id")
    private Integer advertisementId;

    /**
     * TODO 
     */
    //@Column(name = "user_id")
    private String userId;

    /**
     * TODO 
     */
    //@Column(name = "creator_id")
    private String creatorId;

    /**
     * TODO 
     */
    //@Column(name = "advertisement_img")
    private String advertisementImg;

    /**
     * TODO 
     */
    //@Column(name = "advertisement_url")
    private String advertisementUrl;

    /**
     * TODO 
     */
    //@Column(name = "clicks_count")
    private Integer clicksCount;

    /**
     * TODO 
     */
    //@Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * TODO 
     */
    //@Column(name = "update_time")
    private LocalDateTime updateTime;

}
