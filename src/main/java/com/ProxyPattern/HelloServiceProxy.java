package com.ProxyPattern;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 19:16 2019/8/10
 * @Modified By: 代理类角色: HelloServiceProxy类
 */
public class HelloServiceProxy implements HelloService {
    public HelloService helloService;

    public HelloServiceProxy(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String hello(String name) {
        System.out.println("预处理");
        String result = helloService.hello(name);
        System.out.println(result);
        System.out.println("处理后");
        return result;
    }

    @Override
    public String hi(String msg) {
        System.out.println("预处理");
        String result = helloService.hi(msg);
        System.out.println(result);
        System.out.println("处理后");
        return result;
    }
}
