package com.github.yuzhian.java.version.java6.scripting;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 脚本引擎(scoop 安装的 jdk 估计有修改, engine == null)
 *
 * @author yuzhian
 */
public class DemoScripting {
    public static void main(String[] args) throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
        // ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");
        // ScriptEngine engine = new ScriptEngineManager().getEngineByMimeType("text/javascript");
        if (engine == null) {
            throw new RuntimeException("engine == null");
        }
        engine.eval("console.log('hello world!')");
    }
}