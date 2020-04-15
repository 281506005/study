package key.study.JDKProxy;


import sun.misc.ProxyGenerator;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

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
            System.out.println(study);
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
}
