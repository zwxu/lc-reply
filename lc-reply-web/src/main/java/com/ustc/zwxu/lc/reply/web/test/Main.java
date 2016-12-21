package com.ustc.zwxu.lc.reply.web.test;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.zwxu.lc.um.api.StudentQueryService;
import com.zwxu.lc.um.bean.QueryStudentResult;
import com.ustc.zwxu.lc.reply.*;
import com.ustc.zwxu.lc.reply.web.interceptor.HelloChina;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JaxWsProxyFactoryBean factory=new JaxWsProxyFactoryBean();  
        factory.setServiceClass(StudentQueryService.class);  
          
        factory.setAddress("http://localhost:8082/lc-um-core/services/studentQueryService");  
        StudentQueryService service=(StudentQueryService)factory.create();  
        //QueryStudentResult result = service.queryAll();
        System.out.println(service);
        //new HelloChina()。say(); 不同访问
	}

}


