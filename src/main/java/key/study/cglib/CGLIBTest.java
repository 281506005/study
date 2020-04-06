package key.study.cglib;


import key.study.JDKProxy.StudyProxy;

public class CGLIBTest {

    public static void main(String[] args) {
        Study study = (Study) new StudyCGLIBProxy().getInstance(new JavaStudy());
        study.codeSource();
    }
}
