package ${packageName};

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
import ${lastRenderResponse.dto.packageName}.${lastRenderResponse.dto.className};
import ${lastRenderResponse.response.packageName}.${lastRenderResponse.response.className};
import ${lastRenderResponse.service.packageName}.${lastRenderResponse.service.className};

/**
 * controller for ${entity.className}
 * ${comments}
 *
 * @author ${author}
 * Created On ${date}.
 */
@Service
public class ${className} {

    @Autowired
    private ${lastRenderResponse.service.className} ${lastRenderResponse.service.className?uncap_first};

    /**
     * 新增
     *
     * @param ${lastRenderResponse.dto.className?uncap_first}
     * @return
     */
    public ResponseEntity<?> create(${lastRenderResponse.dto.className} ${lastRenderResponse.dto.className?uncap_first}) {
        ${lastRenderResponse.response.className} ${entity.className?uncap_first}Resp = ${lastRenderResponse.service.className?uncap_first}.create(${lastRenderResponse.dto.className?uncap_first});
        return super.doResource(${entity.className?uncap_first}Resp, this.getClass());
    }

    /**
     * 根据主键删除，支持批量主键删除
     *
     * @param ids
     * @return
     */
    public ResponseDto<?> delete(@PathVariable List<${entity.id.className}> ids) {
        ${lastRenderResponse.service.className?uncap_first}.deleteByIds(ids);
        return ResponseDto.success(null);
    }

    /**
     * 更新
     *
     * @param ${lastRenderResponse.dto.className}
     * @param id
     * @return
     */
    public ResponseEntity<?> update(${entity.id.className} id,@RequestBody ${lastRenderResponse.dto.className} ${lastRenderResponse.dto.className?uncap_first}) {
        ${lastRenderResponse.response.className} ${entity.className?uncap_first}Resp = ${lastRenderResponse.service.className?uncap_first}.update(id,${lastRenderResponse.dto.className?uncap_first});
        return super.doResource(${entity.className?uncap_first}Resp, this.getClass());
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    public ResponseEntity<?> details( ${entity.id.className} id) {
        ${lastRenderResponse.response.className} ${entity.className?uncap_first}Resp = ${lastRenderResponse.service.className?uncap_first}.details(id);
        return super.doResource(${entity.className?uncap_first}Resp, this.getClass());
    }

    public HttpEntity<PagedModel<?>> getPageData(
            int pageNumber,
            int pageSize,
            String sortTypes,
            ServletRequest request) {
        // 获取搜索参数
        Map<String, Object> searchParams = super.getSearchParamStartWith(request, IConstants.EMPTY_SEARCH_PREFIX);
        PageInfo pageInfo = new PageInfo(pageNumber, pageSize, sortTypes);
        Page<${lastRenderResponse.response.className}> page = ${lastRenderResponse.service.className?uncap_first}.getPageList(searchParams, pageInfo);
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
        List<${lastRenderResponse.response.className}> dataList = ${lastRenderResponse.service.className?uncap_first}.findByParams(searchParams,sortTypes);
        return super.doListResources(dataList, this.getClass());
    }
}
