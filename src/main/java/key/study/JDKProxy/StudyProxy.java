package key.study.JDKProxy;

import java.lang.reflect.Proxy;

import java.lang.reflect.InvocationHandler;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StudyProxy implements InvocationHandler {

    private Study study;

    //动态代理返回一个实例对象
    //jDK动态代理必须实现接口
//    public Object getInstance(Study study) {
//        this.study = study;
//        Class target = study.getClass();
//        return Proxy.newProxyInstance(target.getClassLoader(),target.getInterfaces(),this);
//    }

    public Object getInstance(Study study) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        this.study = study;
        Class target = study.getClass();
//        return  StudyProxyTemp.newProxyInstance(target,target.getClassLoader(),this);
        return Proxy.newProxyInstance(target.getClassLoader(),target.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("记得练习");
        method.invoke(this.study,args);
        return null;
    }


}
