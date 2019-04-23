package com.ww.study.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Program: study-messy
 * @Description: 全局异常处理类，使用@ControllerAdvice注解在类中标注，
 * 方法当中使用@ExceptionHandler注解进行表示，括号中是异常类的class对象。
 *
 * 疑问:异常捕获的顺序和方法的顺序有关吗？
 * (try/catch catch块捕获异常的顺序是从小到大的，如果最上面捕获Exception，下面捕获RuntimeException，
 * 程序出现RuntimeException后直接被最上层捕获，我的疑问也是由此出现的)
 * 答案:处理异常方法的顺序和捕获的顺序无关，也就是捕获处理Exception的方法可以写在第一个，并不影响。
 *
 * @ExceptionHandler(异常类)这个注解表示Controller中任何一个方法发生异常，
 * 则会被注解了@ExceptionHandler的方法拦截到。对应的异常类执行对应的方法，
 * 如果都没有匹配到异常类，则采用近亲匹配的方式。
 *
 * @Author: Sun
 * @Create: 2019-04-22 15:39
 * @Version: 1.0
 **/
@ControllerAdvice
@Slf4j
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public void handleException(Exception e) {
        log.error("程序运行异常 : {}", e.getMessage());
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public void handleException(RuntimeException e) {
        log.error("程序运行异常 : {}", e.getMessage());
    }

}