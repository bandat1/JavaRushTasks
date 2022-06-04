package com.javarush.task.task32.task3205;

import com.javarush.task.task32.task3205.SomeInterfaceWithMethods;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author denis
 */
public class CustomInvocationHandler implements InvocationHandler {
    SomeInterfaceWithMethods siwm;

    public CustomInvocationHandler(SomeInterfaceWithMethods siwm) {
        this.siwm = siwm;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " in");
        Object result = method.invoke(siwm, args);
        System.out.println(method.getName() + " out");
        return result;
    }
}
