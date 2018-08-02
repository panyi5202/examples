package com.py.examples.springcloud.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author panyi on 18-4-23.
 */
@RestController
public class DemoController {
    @RequestMapping("/hi")
    public String home(@RequestParam String name,HttpServletRequest req) {
        HttpSession session = req.getSession();
        Object username = session.getAttribute("username");
        if(username == null){
            session.setAttribute("username","admin");
            System.out.println("用户名为空。");
        }else {
            System.out.println("已登录："+String.valueOf(username));
        }
        if (name != null && name.length() > 3) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "hi " + name + ",i am from port:";
    }
}
