package org.jackson.dynamic;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        // 获取编译器
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int ressult = compiler.run(null, null, null, "/Users/youdi/Project/javaProject/Video/src/com/liang/oop/User.java");
        System.out.println(ressult == 0 ? "编译成功" : "失败");

        Runtime run = Runtime.getRuntime();
        Process process = run.exec("java -cp /Users/youdi/Project/javaProject/Video/src/com/liang/oop/ User");

        InputStream in = process.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String info = "";
        while ((info = reader.readLine()) != null) {
            System.out.println(info);
        }
    }
}
