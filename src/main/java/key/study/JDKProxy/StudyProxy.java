package key.study.JDKProxy;

import org.springframework.cglib.proxy.Proxy;

import org.springframework.cglib.proxy.InvocationHandler;
import java.lang.reflect.Method;

public class StudyProxy implements InvocationHandler {

    private Study study;

    //动态代理返回一个实例对象
    //jDK动态代理必须实现接口
    public Object getInstance(Study study){
        this.study = study;
        Class target = study.getClass();
        return Proxy.newProxyInstance(target.getClassLoader(),target.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("记得练习");
        method.invoke(this.study,args);
        return null;
    }
}
