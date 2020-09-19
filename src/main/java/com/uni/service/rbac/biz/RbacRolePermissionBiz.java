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
import com.uni.service.rbac.dto.request.RbacRolePermissionRequestDto;
import com.uni.service.rbac.dto.response.RbacRolePermissionResponseDto;
import com.uni.service.rbac.service.RbacRolePermissionService;

/**
 * controller for RbacRolePermission
 * 这是类的注释
 *
 * @author lait
 * Created On 2020-09-17.
 */
@Service
public class RbacRolePermissionBiz {

    @Autowired
    private RbacRolePermissionService rbacRolePermissionService;

    /**
     * 新增
     *
     * @param rbacRolePermissionRequestDto
     * @return
     */
    public ResponseEntity<?> create(RbacRolePermissionRequestDto rbacRolePermissionRequestDto) {
        RbacRolePermissionResponseDto rbacRolePermissionResp = rbacRolePermissionService.create(rbacRolePermissionRequestDto);
        return super.doResource(rbacRolePermissionResp, this.getClass());
    }

    /**
     * 根据主键删除，支持批量主键删除
     *
     * @param ids
     * @return
     */
    public ResponseDto<?> delete(@PathVariable List<Long> ids) {
        rbacRolePermissionService.deleteByIds(ids);
        return ResponseDto.success(null);
    }

    /**
     * 更新
     *
     * @param RbacRolePermissionRequestDto
     * @param id
     * @return
     */
    public ResponseEntity<?> update(Long id,@RequestBody RbacRolePermissionRequestDto rbacRolePermissionRequestDto) {
        RbacRolePermissionResponseDto rbacRolePermissionResp = rbacRolePermissionService.update(id,rbacRolePermissionRequestDto);
        return super.doResource(rbacRolePermissionResp, this.getClass());
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    public ResponseEntity<?> details( Long id) {
        RbacRolePermissionResponseDto rbacRolePermissionResp = rbacRolePermissionService.details(id);
        return super.doResource(rbacRolePermissionResp, this.getClass());
    }

    public HttpEntity<PagedModel<?>> getPageData(
            int pageNumber,
            int pageSize,
            String sortTypes,
            ServletRequest request) {
        // 获取搜索参数
        Map<String, Object> searchParams = super.getSearchParamStartWith(request, IConstants.EMPTY_SEARCH_PREFIX);
        PageInfo pageInfo = new PageInfo(pageNumber, pageSize, sortTypes);
        Page<RbacRolePermissionResponseDto> page = rbacRolePermissionService.getPageList(searchParams, pageInfo);
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
        List<RbacRolePermissionResponseDto> dataList = rbacRolePermissionService.findByParams(searchParams,sortTypes);
        return super.doListResources(dataList, this.getClass());
    }
}
