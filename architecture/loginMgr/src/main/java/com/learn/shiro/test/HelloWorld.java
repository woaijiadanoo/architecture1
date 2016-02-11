package com.learn.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:myShiroTest.ini");
		
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
		
		SecurityUtils.setSecurityManager(securityManager);
		
		UsernamePasswordToken token = new UsernamePasswordToken("jiang-zh","beiliu");
		
		token.setRememberMe(true);
		
		Subject sub = SecurityUtils.getSubject();
		
		sub.login(token);
		
		boolean flag = sub.isPermitted("c1");
		
		System.out.println(flag);
		
	}

}
