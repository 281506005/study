package key.study.JDKProxy;

import org.apache.catalina.session.StandardManager;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class StudyProxyTemp {
    private static String ln = "\n";

    public static void invok(Class interfaces) throws IOException, ClassNotFoundException {
        //组装类
        String sourceJava = generate(interfaces);
        System.out.println(sourceJava);


        //生成java文件
        FileWriter fileWriter = new FileWriter(interfaces.getPackage()+"$porxy.java");
        fileWriter.write(sourceJava);
        fileWriter.flush();
        fileWriter.close();


        //生成class
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = javaCompiler.getStandardFileManager(null, null, Charset.defaultCharset());
        javaCompiler.getTask(null, manager, null)

        //加载class类
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class object = classLoader.loadClass(interfaces.getPackage()+"$porxy.java");
    }

    /**
     * @param interfaces
     * @return
     */

    private static String generate(Class interfaces) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("import java.lang.reflect.InvocationHandler;").append(ln);
        stringBuilder.append("import java.lang.reflect.Method;").append(ln);
        stringBuilder.append("import java.lang.reflect.Proxy;").append(ln);
        stringBuilder.append("import java.lang.reflect.UndeclaredThrowableException;").append(ln);
        stringBuilder.append("public final class $proxy extends Proxy implements").append(interfaces.getName()).append("{").append(ln);
        stringBuilder.append("    public $proxy(InvocationHandler var1) throws  {").append(ln);
        stringBuilder.append("    super(var1);").append(ln);
        stringBuilder.append("     }").append(ln);
        stringBuilder.append("public final void ").append(interfaces.getInterfaces()[0].getName()).append(" throws  {").append(ln);
        stringBuilder.append("try {").append(ln);
        stringBuilder.append("super.h.invoke(this, m3, (Object[])null);").append(ln);
        stringBuilder.append("} catch (RuntimeException | Error var2) {").append(ln);
        stringBuilder.append("throw var2;").append(ln);
        stringBuilder.append(" } catch (Throwable var3) {").append(ln);
        stringBuilder.append(" throw new UndeclaredThrowableException(var3);").append(ln);
        stringBuilder.append(" }").append(ln);
        stringBuilder.append(" }").append(ln);
        stringBuilder.append("static {").append(ln);
        stringBuilder.append(" try {").append(ln);
        stringBuilder.append(" m1 = Class.forName(\"java.lang.Object\").getMethod(\"equals\", Class.forName(\"java.lang.Object\"));").append(ln);
        stringBuilder.append(" m3 = Class.forName(").append(interfaces.getName()).append(").getMethod(").append(interfaces.getInterfaces()[0].getName()).append(");").append(ln);
        stringBuilder.append("m2 = Class.forName(\"java.lang.Object\").getMethod(\"toString\");").append(ln);
        stringBuilder.append("m0 = Class.forName(\"java.lang.Object\").getMethod(\"hashCode\");").append(ln);
        stringBuilder.append(" } catch (NoSuchMethodException var2) {").append(ln);
        stringBuilder.append(" throw new NoSuchMethodError(var2.getMessage());").append(ln);
        stringBuilder.append(" } catch (ClassNotFoundException var3) {").append(ln);
        stringBuilder.append(" throw new NoClassDefFoundError(var3.getMessage());").append(ln);
        stringBuilder.append(" }").append(ln);
        stringBuilder.append(" }").append(ln);
        stringBuilder.append(" }").append(ln);

        return stringBuilder.toString();
    }
}
