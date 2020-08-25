package com.atguigu.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Chen Jianglin
 * @description
 * @date 2020/8/25 / 15:25
 */
@Controller
public class TestController {

    /**
     * 假设: localhost:8080/SpringMVC01/hello
     */
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello() {
        System.out.println("SUCCESS");
        return "success";
    }

}
