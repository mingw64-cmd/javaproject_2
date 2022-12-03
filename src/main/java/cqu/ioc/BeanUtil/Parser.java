package cqu.ioc.BeanUtil;


import cqu.ioc.Register;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Properties;

/**
 * 读取需要扫描的包并注册bean
 */
public class Parser {

    public static final String SCAN_PACKAGE = "scanPackage";


    private Register register;

    public Parser(Register register){
        this.register = register;
    }

    public void parse(Properties properties){
        String packageName = properties.getProperty(SCAN_PACKAGE);
        doRegister(packageName);
    }


    private void doRegister(String packageName) {
        //通过之前的类的定义获取URL
        URL url = getClass().getClassLoader().getResource("./"+packageName.replaceAll("\\.","/"));
        File dir = new File(url.getFile());
        // form-data的形式传输文件
        for (File file:dir.listFiles()){
            if(file.isDirectory()){
                doRegister(packageName+"."+file.getName());
            }else {
                String className = packageName+"."+file.getName().replaceAll(".class","").trim();
                List<Bean> definitions = Generator.generate(className);
                if(definitions == null)continue;
                this.register.registBeanDefinition(definitions);
            }
        }

    }
}