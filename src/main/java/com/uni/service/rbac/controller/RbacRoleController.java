package com.uni.service.rbac.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uni.framework.crud.base.BaseEndpoint;
import com.uni.framework.crud.base.dto.ResponseDto;
import com.uni.framework.crud.base.utils.IConstants;
import com.uni.framework.crud.base.utils.PageInfo;
import com.uni.service.rbac.dto.request.RbacRoleRequestDto;
import com.uni.service.rbac.dto.response.RbacRoleResponseDto;
import com.uni.service.rbac.service.RbacRoleService;

/**
 * controller for RbacRole
 * 这是类的注释
 *
 * @author lait
 * Created On 2020-10-04.
 */
@RestController
@RequestMapping("/rbacRole")
public class RbacRoleController extends BaseEndpoint {

    @Autowired
    private RbacRoleService rbacRoleService;

    /**
     * 新增
     *
     * @param rbacRoleRequestDto
     * @return
     */
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody RbacRoleRequestDto rbacRoleRequestDto) {
        RbacRoleResponseDto rbacRoleResp = rbacRoleService.create(rbacRoleRequestDto);
        return super.doResource(rbacRoleResp, this.getClass());
    }

    /**
     * 根据主键删除，支持批量主键删除
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/{ids}")
    public ResponseDto<?> delete(@PathVariable List<Long> ids) {
        rbacRoleService.deleteByIds(ids);
        return ResponseDto.success(null);
    }

    /**
     * 更新
     *
     * @param RbacRoleRequestDto
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody RbacRoleRequestDto rbacRoleRequestDto) {
        RbacRoleResponseDto rbacRoleResp = rbacRoleService.update(id,rbacRoleRequestDto);
        return super.doResource(rbacRoleResp, this.getClass());
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> details(@PathVariable Long id) {
        RbacRoleResponseDto rbacRoleResp = rbacRoleService.details(id);
        return super.doResource(rbacRoleResp, this.getClass());
    }

    @Override
    @GetMapping("")
    public HttpEntity<PagedModel<?>> getPageData(
            @RequestParam(value = IConstants.DEFAULT_PAGE_NUM_FIELD, defaultValue = IConstants.DEFAULT_PAGE_NUM_VAL) int pageNumber,
            @RequestParam(value = IConstants.DEFAULT_PAGE_SIZE_FIELD, defaultValue = IConstants.DEFAULT_PAGE_SIZE_VAL) int pageSize,
            @RequestParam(value = IConstants.DEFAULT_SORT_TYPES_FIELD, defaultValue = IConstants.DEFAULT_SORT_TYPE_VAL) String sortTypes,
            ServletRequest request) {
        // 获取搜索参数
        Map<String, Object> searchParams = super.getSearchParamStartWith(request, IConstants.EMPTY_SEARCH_PREFIX);
        PageInfo pageInfo = new PageInfo(pageNumber, pageSize, sortTypes);
        Page<RbacRoleResponseDto> page = rbacRoleService.getPageList(searchParams, pageInfo);
        return super.doPage(pageNumber, pageSize, sortTypes, request, this.getClass(), page);
    }

    /**
     * 条件搜索，返回不分页的列表
     *
     * @param request
     * @return
     */
    @GetMapping("/find/params")
    public ResponseEntity<?> findByParams(
            @RequestParam(value = IConstants.DEFAULT_SORT_TYPES_FIELD, defaultValue = IConstants.DEFAULT_SORT_TYPE_VAL) String sortTypes,
            ServletRequest request) {
        // 1.获取搜索参数
        Map<String, Object> searchParams = super.getSearchParamStartWith(request, IConstants.EMPTY_SEARCH_PREFIX);
        // 2.获取数据
        List<RbacRoleResponseDto> dataList = rbacRoleService.findByParams(searchParams,sortTypes);
        return super.doListResources(dataList, this.getClass());
    }
}
