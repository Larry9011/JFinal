package com.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

public class ActionTestInterceptor implements Interceptor {

	@Override
	public void intercept(ActionInvocation ai) {
		System.out.println("我是Action级拦截器，我是invoke前面的操作方法...");
		ai.invoke();
		System.out.println("我是Action级拦截器，我是invoke后面的操作方法...");
	}


}
