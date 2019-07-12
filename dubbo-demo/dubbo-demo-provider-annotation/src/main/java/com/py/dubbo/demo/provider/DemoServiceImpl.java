package com.py.dubbo.demo.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.py.dubbo.demo.api.DemoService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * @author panyi on 18-8-21.
 */
@Service(protocol = {"dubbo","rest"})
@Path(value = "demo")
public class DemoServiceImpl implements DemoService {

    @Override
    @GET
    @Path(value = "tests")
    @Consumes({MediaType.APPLICATION_JSON})
    public String sayHello(String name) {
        String ret = "OOXX->" + name;
        System.out.println("收到消息：" + ret);
        return ret;
    }
}
