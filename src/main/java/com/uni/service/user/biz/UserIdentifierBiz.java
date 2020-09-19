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
import com.uni.service.user.dto.request.UserIdentifierRequestDto;
import com.uni.service.user.dto.response.UserIdentifierResponseDto;
import com.uni.service.user.service.UserIdentifierService;

/**
 * controller for UserIdentifier
 * 这是类的注释
 *
 * @author lait
 * Created On 2020-09-17.
 */
@Service
public class UserIdentifierBiz {

    @Autowired
    private UserIdentifierService userIdentifierService;

    /**
     * 新增
     *
     * @param userIdentifierRequestDto
     * @return
     */
    public ResponseEntity<?> create(UserIdentifierRequestDto userIdentifierRequestDto) {
        UserIdentifierResponseDto userIdentifierResp = userIdentifierService.create(userIdentifierRequestDto);
        return super.doResource(userIdentifierResp, this.getClass());
    }

    /**
     * 根据主键删除，支持批量主键删除
     *
     * @param ids
     * @return
     */
    public ResponseDto<?> delete(@PathVariable List<Long> ids) {
        userIdentifierService.deleteByIds(ids);
        return ResponseDto.success(null);
    }

    /**
     * 更新
     *
     * @param UserIdentifierRequestDto
     * @param id
     * @return
     */
    public ResponseEntity<?> update(Long id,@RequestBody UserIdentifierRequestDto userIdentifierRequestDto) {
        UserIdentifierResponseDto userIdentifierResp = userIdentifierService.update(id,userIdentifierRequestDto);
        return super.doResource(userIdentifierResp, this.getClass());
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    public ResponseEntity<?> details( Long id) {
        UserIdentifierResponseDto userIdentifierResp = userIdentifierService.details(id);
        return super.doResource(userIdentifierResp, this.getClass());
    }

    public HttpEntity<PagedModel<?>> getPageData(
            int pageNumber,
            int pageSize,
            String sortTypes,
            ServletRequest request) {
        // 获取搜索参数
        Map<String, Object> searchParams = super.getSearchParamStartWith(request, IConstants.EMPTY_SEARCH_PREFIX);
        PageInfo pageInfo = new PageInfo(pageNumber, pageSize, sortTypes);
        Page<UserIdentifierResponseDto> page = userIdentifierService.getPageList(searchParams, pageInfo);
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
        List<UserIdentifierResponseDto> dataList = userIdentifierService.findByParams(searchParams,sortTypes);
        return super.doListResources(dataList, this.getClass());
    }
}
