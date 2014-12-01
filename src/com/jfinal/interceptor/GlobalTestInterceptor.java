package com.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

/**
 * 全局拦截器
 * @author huchengsong
 *
 */
public class GlobalTestInterceptor implements Interceptor {

	@Override
	public void intercept(ActionInvocation ai) {

		System.out.println("我是全局拦截器，我是invoke前面的操作方法...");
		ai.invoke();
		System.out.println("我是全局拦截器，我是invoke后面的操作方法...");
	}

}
