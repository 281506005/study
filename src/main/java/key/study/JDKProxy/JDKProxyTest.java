package key.study.JDKProxy;


import sun.misc.ProxyGenerator;

public class JDKProxyTest {

    public static void main(String[] args) {
        Study study = (Study) new StudyProxy().getInstance(new JavaStudy());
        ProxyGenerator.generateProxyClass()
        study.codeSource();
    }
}
