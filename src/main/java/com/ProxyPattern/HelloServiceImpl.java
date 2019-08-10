package com.ProxyPattern;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 19:15 2019/8/10
 * @Modified By: 委托类角色: HelloServiceImpl类
 */
public class HelloServiceImpl implements HelloService{
    @Override
    public String hello(String name) {
        return "Hello" + name;
    }

    @Override
    public String hi(String msg) {
        return "Hi" + msg;

    }
}
