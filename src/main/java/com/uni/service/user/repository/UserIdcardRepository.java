package com.uni.service.user.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.uni.framework.crud.base.BaseRepository;

import com.uni.service.user.entity.UserIdcard;

/**
 * repository for UserIdcard generated by jpa-codegen
 * 这是类的注释
 *
 * @author lait
 * Created On 2020-09-17.
 */
@RepositoryRestResource(path = "userIdcard", itemResourceRel = "resource", collectionResourceRel = "resources")
public interface UserIdcardRepository extends BaseRepository<UserIdcard, Long> {


}