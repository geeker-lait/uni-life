package com.uni.life.generator.mybatis.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.uni.life.generator.mybatis.service.SysGeneratorService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 代码生成器
 */
@RestController
@RequestMapping("/generator")
public class SysGeneratorController {
    @Autowired
    private SysGeneratorService sysGeneratorService;

    /**
     * 列表
     */
//    @ResponseBody
//    @GetMapping("/list")
//    public PageResult getTableList(@RequestParam Map<String, Object> params) {
//        return sysGeneratorService.queryList(params);
//    }

    /**
     * 生成代码FileUtil
     */
    @GetMapping("/code")
    public void makeCode(String tables, HttpServletResponse response) throws IOException {
        byte[] data = sysGeneratorService.generatorCode(tables.split(","));
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"generator.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }
}
