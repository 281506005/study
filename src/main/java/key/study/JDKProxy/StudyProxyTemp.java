package key.study.JDKProxy;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

public class StudyProxyTemp {
    private static String ln = "\n";

    public static Object invok(Class interfaces, ClassLoader classLoader, InvocationHandler invocationHandler) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //组装类
        String sourceJava = generate(interfaces);
        System.out.println(interfaces.getResource("").getPath());
        String path = interfaces.getResource("").getPath();

        //生成java文件
        File file = new File(path+"$proxy.java");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(sourceJava);
        fileWriter.flush();
        fileWriter.close();


        //生成class
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = javaCompiler.getStandardFileManager(null, null, null);
        Iterable iterable = manager.getJavaFileObjects(file);
        JavaCompiler.CompilationTask compilationTask = javaCompiler.getTask(null, manager, null,null,null,iterable);
        compilationTask.call();
        manager.close();

        //加载class类
        Class object = classLoader.loadClass(path+"$proxy");
        Constructor constructor = object.getConstructor(InvocationHandler.class);
        return constructor.newInstance(invocationHandler);
    }

    /**
     * @param interfaces
     * @return
     */

    private static String generate(Class interfaces) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("package key.study.JDKProxy;").append(ln);
        stringBuilder.append("import java.lang.reflect.InvocationHandler;").append(ln);
        stringBuilder.append("import java.lang.reflect.Method;").append(ln);
        stringBuilder.append("import java.lang.reflect.Proxy;").append(ln);
        stringBuilder.append("import ").append(interfaces.getName()).append(";").append(ln);
        stringBuilder.append("import java.lang.reflect.UndeclaredThrowableException;").append(ln);
        stringBuilder.append("public final class $proxy extends Proxy implements ").append(interfaces.getInterfaces()[0].getName()).append("{").append(ln);
        stringBuilder.append("    private static Method m1; ").append(ln);
        stringBuilder.append("    private static Method m2; ").append(ln);
        stringBuilder.append("    private static Method m3; ").append(ln);
        stringBuilder.append("    private static Method m0; ").append(ln);
        stringBuilder.append("    public $proxy(InvocationHandler var1)  {").append(ln);
        stringBuilder.append("    super(var1);").append(ln);
        stringBuilder.append("     }").append(ln);
        stringBuilder.append("public final void ").append(interfaces.getInterfaces()[0].getMethods()[0].getName()).append("  (){").append(ln);
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
        stringBuilder.append(" m3 = Class.forName(\"").append(interfaces.getName()).append("\").getMethod(\"").append(interfaces.getInterfaces()[0].getMethods()[0].getName()).append("\");").append(ln);
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
