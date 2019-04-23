package com.ww.study.studySlf4j;

import lombok.extern.slf4j.Slf4j;

/**
 * @Program: study-messy
 * @Description: 学习使用Slf4j记录日志
 * 加入@Slf4j注解后，实际上会编译为
 * private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LogExample.class);
 * @Author: Sun
 * @Create: 2019-04-23 17:01
 * @Version: 1.0
 **/
@Slf4j
public class StudySlf4j {

    public static void main(String[] args) {
        test("1", "2", "3");
    }


    public static void test(String userVo, String verificationCode, String password) {
        // 使用占位符来进行取值
        log.info("[register] [userVo:{}] [verificationCode:{}] [password:{}]", userVo, verificationCode, password);
        log.error("[register] [phone:{}]", "手机号为空");
        log.debug("debug");
        log.warn("warn");
    }
}
