package com.uni.service.rbac.biz;

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
import com.uni.service.rbac.dto.request.RbacPermissionRequestDto;
import com.uni.service.rbac.dto.response.RbacPermissionResponseDto;
import com.uni.service.rbac.service.RbacPermissionService;

/**
 * controller for RbacPermission
 * 这是类的注释
 *
 * @author lait
 * Created On 2020-09-17.
 */
@Service
public class RbacPermissionBiz {

    @Autowired
    private RbacPermissionService rbacPermissionService;

    /**
     * 新增
     *
     * @param rbacPermissionRequestDto
     * @return
     */
    public ResponseEntity<?> create(RbacPermissionRequestDto rbacPermissionRequestDto) {
        RbacPermissionResponseDto rbacPermissionResp = rbacPermissionService.create(rbacPermissionRequestDto);
        return super.doResource(rbacPermissionResp, this.getClass());
    }

    /**
     * 根据主键删除，支持批量主键删除
     *
     * @param ids
     * @return
     */
    public ResponseDto<?> delete(@PathVariable List<Long> ids) {
        rbacPermissionService.deleteByIds(ids);
        return ResponseDto.success(null);
    }

    /**
     * 更新
     *
     * @param RbacPermissionRequestDto
     * @param id
     * @return
     */
    public ResponseEntity<?> update(Long id,@RequestBody RbacPermissionRequestDto rbacPermissionRequestDto) {
        RbacPermissionResponseDto rbacPermissionResp = rbacPermissionService.update(id,rbacPermissionRequestDto);
        return super.doResource(rbacPermissionResp, this.getClass());
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    public ResponseEntity<?> details( Long id) {
        RbacPermissionResponseDto rbacPermissionResp = rbacPermissionService.details(id);
        return super.doResource(rbacPermissionResp, this.getClass());
    }

    public HttpEntity<PagedModel<?>> getPageData(
            int pageNumber,
            int pageSize,
            String sortTypes,
            ServletRequest request) {
        // 获取搜索参数
        Map<String, Object> searchParams = super.getSearchParamStartWith(request, IConstants.EMPTY_SEARCH_PREFIX);
        PageInfo pageInfo = new PageInfo(pageNumber, pageSize, sortTypes);
        Page<RbacPermissionResponseDto> page = rbacPermissionService.getPageList(searchParams, pageInfo);
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
        List<RbacPermissionResponseDto> dataList = rbacPermissionService.findByParams(searchParams,sortTypes);
        return super.doListResources(dataList, this.getClass());
    }
}
