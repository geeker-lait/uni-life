package com.uni.life.auth.core.properties;

import com.uni.life.auth.core.social.configutils.SocialProperties;
import lombok.Data;

/**
 * @date : 2019/9/15 22:33
 * Description：
 */
@Data
public class WeiXinProperties extends SocialProperties {
    private String providerId = "weixin";
}
