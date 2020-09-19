package com.uni.life.crud;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @Author lait.zhang@gmail.com
 * @Tel 15801818092
 * @Date 8/16/2020
 * @Description ${Description}
 */
@Data
@MappedSuperclass
public class IdEntity {
    /** 实体ID, 主键 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
}
