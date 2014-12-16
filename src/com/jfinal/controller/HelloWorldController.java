package com.jfinal.controller;

import com.jfinal.core.Controller;

public class HelloWorldController extends Controller {

	/**
	 * 展示HelloWord视图
	 */
	public void index(){

		String msg = "Welcome To Jfinal World!!";
		setAttr("helloworld",msg);
		render("helloworld.html");  // 渲染你跳转的页面
	}
}
