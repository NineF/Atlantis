//package com.bulingbuu.filter;
//
//import org.python.core.Py;
//import org.python.core.PyObject;
//import org.python.core.PyString;
//import org.python.util.PythonInterpreter;
//
//import java.util.Properties;
//
///**
// * @author bulingbuu
// * @date 18-11-15 上午11:32
// */
//public class PythonDFAFilter {
//    public static void main(String[] args) throws InterruptedException {
//
//        Properties props = new Properties();
//        props.put("python.home", "/usr/lib/python2.7/");
//        props.put("python.console.encoding", "UTF-8");
//        props.put("python.security.respectJavaAccessibility", "false");
//        props.put("python.import.site", "false");
//        Properties preprops = System.getProperties();
//        PythonInterpreter.initialize(preprops, props, new String[0]);
//
//
//        // 面向对象式编程: 在Java中调用Python对象实例的方法
//        String pythonClass = "filter.py";
//        // python对象名
//        String pythonObjName = "filter";
//        // python类名
//        String pythonClazzName = "DFAFilter";
//        PythonInterpreter pi2 = new PythonInterpreter();
//        // 加载python程序
//        pi2.execfile(pythonClass);
//        // 实例化python对象
//        pi2.exec(pythonObjName + "=" + pythonClazzName + "()");
//        // 获取实例化的python对象
//        PyObject pyObj = pi2.get(pythonObjName);
//
//        long start=System.currentTimeMillis();
//
//        // 调用python对象方法,传递参数并接收返回值
//        pyObj.invoke("parse", new PyObject[]{Py.newString("keywords")});
//
//        long end=System.currentTimeMillis();
//
//        PyString result = (PyString) pyObj.invoke("filter", new PyObject[]{Py.newStringUTF8("是是是")});
//
//        long end2=System.currentTimeMillis();
//
//        System.out.println(end-start);
//        System.out.println(result.asString());
//
//        pi2.cleanup();
//        pi2.close();
//
//
//    }
//}
