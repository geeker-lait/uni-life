package com.uni.service.user.biz;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.uni.framework.crud.base.BaseEndpoint;
import com.uni.framework.crud.base.dto.ResponseDto;
import com.uni.framework.crud.base.utils.IConstants;
import com.uni.framework.crud.base.utils.PageInfo;
import com.uni.service.user.dto.request.UserRelationshipRequestDto;
import com.uni.service.user.dto.response.UserRelationshipResponseDto;
import com.uni.service.user.service.UserRelationshipService;

/**
 * controller for UserRelationship
 * 这是类的注释
 *
 * @author lait
 * Created On 2020-10-04.
 */
@Service
public class UserRelationshipBiz {

    @Autowired
    private UserRelationshipService userRelationshipService;

    /**
     * 新增
     *
     * @param userRelationshipRequestDto
     * @return
     */
    public ResponseEntity<?> create(UserRelationshipRequestDto userRelationshipRequestDto) {
        UserRelationshipResponseDto userRelationshipResp = userRelationshipService.create(userRelationshipRequestDto);
        return super.doResource(userRelationshipResp, this.getClass());
    }

    /**
     * 根据主键删除，支持批量主键删除
     *
     * @param ids
     * @return
     */
    public ResponseDto<?> delete(@PathVariable List<Long> ids) {
        userRelationshipService.deleteByIds(ids);
        return ResponseDto.success(null);
    }

    /**
     * 更新
     *
     * @param UserRelationshipRequestDto
     * @param id
     * @return
     */
    public ResponseEntity<?> update(Long id,@RequestBody UserRelationshipRequestDto userRelationshipRequestDto) {
        UserRelationshipResponseDto userRelationshipResp = userRelationshipService.update(id,userRelationshipRequestDto);
        return super.doResource(userRelationshipResp, this.getClass());
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    public ResponseEntity<?> details( Long id) {
        UserRelationshipResponseDto userRelationshipResp = userRelationshipService.details(id);
        return super.doResource(userRelationshipResp, this.getClass());
    }

    public HttpEntity<PagedModel<?>> getPageData(
            int pageNumber,
            int pageSize,
            String sortTypes,
            ServletRequest request) {
        // 获取搜索参数
        Map<String, Object> searchParams = super.getSearchParamStartWith(request, IConstants.EMPTY_SEARCH_PREFIX);
        PageInfo pageInfo = new PageInfo(pageNumber, pageSize, sortTypes);
        Page<UserRelationshipResponseDto> page = userRelationshipService.getPageList(searchParams, pageInfo);
        return super.doPage(pageNumber, pageSize, sortTypes, request, this.getClass(), page);
    }

    /**
     * 条件搜索，返回不分页的列表
     *
     * @param request
     * @return
     */
    public ResponseEntity<?> findByParams(
            String sortTypes,
            ServletRequest request) {
        // 1.获取搜索参数
        Map<String, Object> searchParams = super.getSearchParamStartWith(request, IConstants.EMPTY_SEARCH_PREFIX);
        // 2.获取数据
        List<UserRelationshipResponseDto> dataList = userRelationshipService.findByParams(searchParams,sortTypes);
        return super.doListResources(dataList, this.getClass());
    }
}
