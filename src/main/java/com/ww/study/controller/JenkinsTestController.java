package com.ww.study.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试Jenkins自动部署Api.
 * @author: Sun
 * @create: 2019-08-27 14:46
 * @version: v1.0
 */
@RestController
@RequestMapping(value = "/jenkins")
@Slf4j
public class JenkinsTestController {

    /**
     * 提交git代码 触发Jenkins自动部署
     * @return
     */
    @RequestMapping("/hello")
    public String helloJenkins() {
        log.info("[helloJenkins] [Hello,I'm Jenkins!]");
        return "Hello,I'm Jenkins!";
    }
}
