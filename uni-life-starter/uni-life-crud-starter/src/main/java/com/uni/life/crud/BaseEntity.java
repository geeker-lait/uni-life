package com.uni.life.crud;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础实体信息<br>
 * 所有的实体都继承该对象（每个数据表都相同的字段）<br>
 *
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    /** 实体ID, 主键 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    /**
     * 创建人
     */
    @CreatedBy
    protected String createdBy;

    /** 实体创建时间 */
    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime createdDate;

    /** 实体删除标记，为false表示删除 */
    protected Boolean isActive = Boolean.TRUE;


    // 租户id
    private	Long	tenantId;
    // 应用id
    private	String	appId;
/*    // 应用版本
    private	String	appVersion;*/

}
