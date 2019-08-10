package com.ProxyPattern.JDKDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: hqf
 * @description: 该接口包含一个invoke方法，通过该方法实现对委托类的代理的访问，是代理类完整逻辑的集中体现，
 *                  包括要切入的增强逻辑和进行反射执行的真实业务逻辑。
 * @Data: Create in 20:10 2019/8/10
 * @Modified By:
 */
public class MyInvocationHandler implements InvocationHandler {
    // 真实业务对象
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 该方法代理类完整逻辑的集中体现。第一个参数既是代理类实例，第二个参数是被调用的方法对象，
     * 第三个方法是调用参数。通常通过反射完成对具体角色业务逻辑的调用，并对其进行增强。
     * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 增强逻辑
        System.out.println("PROXY : " + proxy.getClass().getName());

        // 反射调用，目标方法
        Object result = method.invoke(target, args);

        // 增强逻辑
        System.out.println(method.getName() + " : " + result);

        return result;
    }
}
