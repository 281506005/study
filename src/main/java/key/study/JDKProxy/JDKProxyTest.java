package key.study.JDKProxy;


import sun.misc.ProxyGenerator;

import java.io.*;

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
//
//        study.codeSource();

        try {
            StudyProxyTemp.invok(JavaStudy.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
