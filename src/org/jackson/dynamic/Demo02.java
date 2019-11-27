package org.jackson.dynamic;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.List;

/**
 * 测试脚本引擎
 */

public class Demo02 {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        ScriptEngineManager sem = new ScriptEngineManager();

        ScriptEngine engine = sem.getEngineByName("javascript");

        // 定义变量， 保存在上下文中
        engine.put("msg", "jackson is the one");

        // 执行脚本
        String str = "var user = {name:'xix', age:18, schools:['清华']};";
        str += "print(user.name);";
        engine.eval(str);

        // 修改变量
        engine.eval("msg = 'helo';");
        System.out.println(engine.get("msg"));

        // 定义函数
        engine.eval("function add(a,b) {return a+b;}");

        //执行js函数
        Invocable jsInvoke = (Invocable) engine;
        Object result = jsInvoke.invokeFunction("add", new Object[]{12, 30});

        System.out.println(result);

        // 导入其他的java包，使用其他的包中java类
        String jsCode = "importPackage(java.util);var list=Arrays.asList([1,10,4,6,0,4,3,2]);";
        engine.eval(jsCode);

        List<Integer> list2 = (List<Integer>) engine.get("list");

        for (Integer tmp : list2
        ) {
            System.out.println(tmp);
        }


    }

    public void say(int one) {
        System.out.println("hello" + one);
    }
}
