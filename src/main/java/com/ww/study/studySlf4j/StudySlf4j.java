package com.ww.study.studySlf4j;

import lombok.extern.slf4j.Slf4j;

/**
 * @Program: study-messy
 * @Description: 学习使用Slf4j记录日志
 * 加入@Slf4j注解后，实际上会编译为
 * private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LogExample.class);
 *
 * 为什么使用SLF4J而不是直接使用Log4j或者Logback？
 * 1、SLF4J，即简单日志门面（Simple Logging Facade for Java），他不是具体的日志解决方案，它只是服务于各种各样的日志系统。
 * 说白了SLF4J是一个日志抽象层，允许你使用任何一个日志系统，并且可以随时切换还不需要动已经写好的程序。
 * 2、简洁的占位符，降低了代码中字符串连接次数，而且还节省了新建的String对象。
 *
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
