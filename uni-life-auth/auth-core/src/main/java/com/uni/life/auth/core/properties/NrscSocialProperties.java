package com.uni.life.auth.core.properties;

import lombok.Data;

/**
 * @date : 2019/8/7 20:45
 * Description:
 */
@Data
public class NrscSocialProperties {
    private String filterProcessesUrl = "/auth";

    private QQProperties qq = new QQProperties();

    private WeiXinProperties weixin = new WeiXinProperties();
}
