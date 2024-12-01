package stu01.controller;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usr")
public class UserControl {

    // 定义了一个映射到路径"/stu/getUserInfoByName"的GET请求处理方法
    @GetMapping("/getUserByName")
    public Object[] getUserInfoByName(@RequestParam("name")String name){
        // 创建JaxWsDynamicClientFactory实例，用于动态创建客户端
        JaxWsDynamicClientFactory proxyFactoryBean =  JaxWsDynamicClientFactory.newInstance();
        // 使用动态客户端工厂创建客户端对象，并指定WebService的WSDL地址
        Client client = proxyFactoryBean.createClient("http://localhost:8080/wbs/user-server?wsdl");
        // 定义一个Object数组用于存储调用WebService方法后的返回结果
        Object[] objects = new Object[0];
        
        // 调用远程WebService方法
        try {
            // 调用客户端的invoke方法，传入方法名和参数，获取WebService方法的返回结果
            objects = client.invoke("getUserByName", name);
        } catch (Exception e) {
            // 捕获异常，打印异常信息
            e.printStackTrace();
        }
        // 返回WebService方法的返回结果
        return objects;
    }
}


