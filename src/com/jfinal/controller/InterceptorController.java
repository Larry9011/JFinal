package com.jfinal.controller;

import com.jfinal.aop.Before;
import com.jfinal.aop.ClearInterceptor;
import com.jfinal.aop.ClearLayer;
import com.jfinal.core.Controller;
import com.jfinal.interceptor.ActionTestInterceptor;
import com.jfinal.interceptor.ControllerTestInterceptor;

@Before(ControllerTestInterceptor.class)  // Controller级别Interceptor的定义
public class InterceptorController  extends Controller {

	@Before(ActionTestInterceptor.class)  // Action级别Interceptor的定义
	public void index(){
		System.out.println("我是中间方法");
		renderText("success");
	}

	@ClearInterceptor  // 清楚上一级的拦截器（Controller级别的）
	public void destroyControllerInterceptor(){
		System.out.println("清楚上一级的拦截器（Controller级别的）");
		renderText("success");
	}

	@ClearInterceptor(ClearLayer.ALL)//清除多级Interceptor
	public void destroyAllInterceptor(){
		System.out.println("清除多级Interceptor");
		renderText("success");
	}
}
