package com.ProxyPattern;

/**
 * @Author: hqf
 * @description:  这是一个静态的代理模式，其中委托类和代理类都需要实现HelloService抽象类的接口。在main函数里面，我们调用的是代理类的方法，有以下优点
 * 1、代理对象存在的价值主要用于拦截对真实业务对象的访问；
 * 2、代理对象具有和目标对象(真实业务对象)实现共同的接口或继承于同一个类；
 * 3、代理对象是对目标对象的增强，以便对消息进行预处理和后处理。
 *
 *
 * @Data: Create in 19:19 2019/8/10
 * @Modified By:
 */
public class myMian {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        HelloServiceProxy helloServiceProxy = new HelloServiceProxy(helloService);
        helloServiceProxy.hello("abc");
        helloServiceProxy.hi("cba");
    }
}
