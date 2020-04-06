package key.study.cglib;

import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;

public class StudyCGLIBProxy implements MethodInterceptor {

    private Study study;

    //动态代理返回一个实例对象
    //jDK动态代理必须实现接口
    public Object getInstance(Study study){
        Enhancer enhancer = new Enhancer();
        this.study = study;
        Class target = study.getClass();
        enhancer.setSuperclass(target);
        enhancer.setCallback(this);

        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("记得练习");
        method.invoke(this.study,objects);
        return null;
    }
}
