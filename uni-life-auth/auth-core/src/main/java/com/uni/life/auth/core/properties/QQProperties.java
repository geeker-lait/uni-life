package com.uni.life.auth.core.properties;

import com.uni.life.auth.core.social.configutils.SocialProperties;
import lombok.Data;

/**
 * @date : 2019/8/7 20:43
 * Description:
 */
@Data
public class QQProperties extends SocialProperties {
    private String providerId = "qq";
}
