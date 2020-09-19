package com.uni.framework.crud.base.xss;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @RequestBody 注解的请求参数进行XSS过滤<br>
 *              本方案 对 @RequestBody String 无效<br>
 *              该方案无法对单个字段做特殊处理，全部会被转义。<br>
 * @author barry
 *
 */
public class StringXssDeserializer extends JsonDeserializer<String> {

    private static final Logger log = LoggerFactory.getLogger(StringXssDeserializer.class);

    /**
     * 实现JsonDeserializer的解码方法<br>
     * 用于对请求进行XSS攻击进行过滤
     */
    @Override
    public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        String source = p.getText().trim();
        log.debug("传进来的字符串是={}", source);
//        source = StringEscapeUtils.escapeHtml4(source);
//        log.debug("转换后的字符串是={}", source);
        return StringEscapeUtils.escapeHtml4(source);
    }

}
