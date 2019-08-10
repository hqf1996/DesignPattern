package com.ProxyPattern.JDKDynamicProxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 20:16 2019/8/10
 * @Modified By:
 */
public class myMain {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        HelloService helloService = new HelloServiceImpl();

        // 生成代理类的class对象 该方法用于获取关联于指定类装载器和一组接口的动态代理类的类对象
        Class<?> clazz = Proxy.getProxyClass(helloService.getClass().getClassLoader(), helloService
                .getClass().getInterfaces());
        // 创建InvocationHandler
        InvocationHandler myInvocationHandler = new MyInvocationHandler(helloService);
        // 获取代理类的构造器对象
        Constructor constructor = clazz.getConstructor(new Class[] {InvocationHandler.class});
        // 反射创建代理对象 该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例
        HelloService proxy = (HelloService)constructor.newInstance(myInvocationHandler);

        /***
         * 上面那部分内容也可以简写成以下部分
         */
//        HelloService proxy = (HelloService)Proxy.newProxyInstance(HelloService.class.getClassLoader(),
//        helloService.getClass().getInterfaces(), new MyInvocationHandler(helloService));

        proxy.hello("abc");
        proxy.hi("cba");
    }
}
