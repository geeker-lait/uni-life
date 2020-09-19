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
import com.uni.service.user.dto.request.UserOrgRequestDto;
import com.uni.service.user.dto.response.UserOrgResponseDto;
import com.uni.service.user.service.UserOrgService;

/**
 * controller for UserOrg
 * 这是类的注释
 *
 * @author lait
 * Created On 2020-09-17.
 */
@Service
public class UserOrgBiz {

    @Autowired
    private UserOrgService userOrgService;

    /**
     * 新增
     *
     * @param userOrgRequestDto
     * @return
     */
    public ResponseEntity<?> create(UserOrgRequestDto userOrgRequestDto) {
        UserOrgResponseDto userOrgResp = userOrgService.create(userOrgRequestDto);
        return super.doResource(userOrgResp, this.getClass());
    }

    /**
     * 根据主键删除，支持批量主键删除
     *
     * @param ids
     * @return
     */
    public ResponseDto<?> delete(@PathVariable List<Long> ids) {
        userOrgService.deleteByIds(ids);
        return ResponseDto.success(null);
    }

    /**
     * 更新
     *
     * @param UserOrgRequestDto
     * @param id
     * @return
     */
    public ResponseEntity<?> update(Long id,@RequestBody UserOrgRequestDto userOrgRequestDto) {
        UserOrgResponseDto userOrgResp = userOrgService.update(id,userOrgRequestDto);
        return super.doResource(userOrgResp, this.getClass());
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    public ResponseEntity<?> details( Long id) {
        UserOrgResponseDto userOrgResp = userOrgService.details(id);
        return super.doResource(userOrgResp, this.getClass());
    }

    public HttpEntity<PagedModel<?>> getPageData(
            int pageNumber,
            int pageSize,
            String sortTypes,
            ServletRequest request) {
        // 获取搜索参数
        Map<String, Object> searchParams = super.getSearchParamStartWith(request, IConstants.EMPTY_SEARCH_PREFIX);
        PageInfo pageInfo = new PageInfo(pageNumber, pageSize, sortTypes);
        Page<UserOrgResponseDto> page = userOrgService.getPageList(searchParams, pageInfo);
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
        List<UserOrgResponseDto> dataList = userOrgService.findByParams(searchParams,sortTypes);
        return super.doListResources(dataList, this.getClass());
    }
}
