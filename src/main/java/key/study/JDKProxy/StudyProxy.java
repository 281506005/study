package key.study.JDKProxy;

import org.springframework.cglib.proxy.Proxy;

import org.springframework.cglib.proxy.InvocationHandler;

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
        return  StudyProxyTemp.invok(target,target.getClassLoader(),this);
//        return Proxy.newProxyInstance(target.getClassLoader(),target.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("记得练习");
        method.invoke(this.study,args);
        return null;
    }

    static {
        try {
             Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
//            m3 = Class.forName(key.study.JDKProxy.JavaStudy).getMethod(key.study.JDKProxy.Study);
             Class.forName("java.lang.Object").getMethod("toString");
            Class.forName("java.lang.Object").getMethod("hashCode");
        } catch (NoSuchMethodException var2) {
            throw new NoSuchMethodError(var2.getMessage());
        } catch (ClassNotFoundException var3) {
            throw new NoClassDefFoundError(var3.getMessage());
        }
    }
}
