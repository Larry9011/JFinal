package com.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

public class ControllerTestInterceptor implements Interceptor {

	@Override
	public void intercept(ActionInvocation ai) {

		System.out.println("我是Controller级拦截器，我是invoke前面的操作方法...");
		ai.invoke();  // 假如你没有调用这个方法，那么你当前URL请求的方法时不会被执行的
		System.out.println("我是Controller级拦截器，我是invoke后面的操作方法...");
	}

}
