package browser.beans;

import com.alibaba.fastjson.JSON;
import com.uni.life.auth.core.enums.LoginType;
import com.uni.life.auth.core.enums.ResultEnum;
import com.uni.life.auth.core.properties.NrscSecurityProperties;
import com.uni.life.auth.core.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created Date: 2019/6/18 19:46
 */
@Slf4j
@Component("NRSCAuthenticationFailureHandler")
public class NRSCAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

//    @Autowired
//    private ObjectMapper objectMapper;

    @Autowired
    private NrscSecurityProperties nrscSecurityProperties;

    /**
     * AuthenticationException里封装了用户登陆失败的错误信息
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        AuthenticationException e)
            throws IOException, ServletException {

        log.error("登陆失败");
        if (LoginType.JSON.equals(nrscSecurityProperties.getBrowser().getLoginType())) {
            //修改状态码
            httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            //设置返回内容的数据形式和编码格式
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            //将抓到的错误信息以json数据的形式进行返回
            httpServletResponse.getWriter().write(JSON.toJSONString
                    (ResultVOUtil.error(ResultEnum.LOGIN_FAILURE.getCode(), e.getMessage())));
        } else {
            super.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
        }
    }
}
