package key.study.JDKProxy;


import sun.misc.ProxyGenerator;

import java.io.*;
import java.lang.reflect.*;

public class JDKProxyTest {

    public static void main(String[] args) {
//        Study study = (Study) new StudyProxy().getInstance(new JavaStudy());
//        Class<?> classes [] = {Study.class};
//        byte[] bytes = ProxyGenerator.generateProxyClass("$proxy",classes);
//        FileOutputStream file = null;
//        try {
//            file = new FileOutputStream("D:\\workspace\\$porxy.class");
////            FileWriter fileWriter = new FileWriter(file);
//            file.write(bytes);
//            file.flush();
//            file.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        study.codeSource();

        try {

            Study study = (Study) new StudyProxy().getInstance(new JavaStudy());
            study.codeSource();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static final class $proxy extends Proxy implements key.study.JDKProxy.Study{
        private static Method m1;
        private static Method m2;
        private static Method m3;
        private static Method m0;
        public $proxy(InvocationHandler var1)  {
            super(var1);
        }
        public final void codeSource  (){
            try {
                super.h.invoke(this, m3, (Object[])null);
            } catch (RuntimeException | Error var2) {
                throw var2;
            } catch (Throwable var3) {
                throw new UndeclaredThrowableException(var3);
            }
        }
        static {
            try {
                m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
                m3 = Class.forName("key.study.JDKProxy.JavaStudy").getMethod("codeSource");
                m2 = Class.forName("java.lang.Object").getMethod("toString");
                m0 = Class.forName("java.lang.Object").getMethod("hashCode");
            } catch (NoSuchMethodException var2) {
                throw new NoSuchMethodError(var2.getMessage());
            } catch (ClassNotFoundException var3) {
                throw new NoClassDefFoundError(var3.getMessage());
            }
        }
    }
}
