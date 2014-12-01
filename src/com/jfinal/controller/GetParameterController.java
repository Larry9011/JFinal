package com.jfinal.controller;

import com.jfinal.core.Controller;


public class GetParameterController extends Controller {


	public void index(){

		renderFreeMarker("param.html");

	}

	public void get1(){

		int id = getParaToInt(0);  // 通过索引值接收GET请求的方式
		System.out.println(id);
		setAttr("msg", "接收成功");
		renderFreeMarker("param.html");
	}


	public void get2(){

		String id = getPara(1);  // 通过索引值接收GET请求的方式
		System.out.println(id);
		String id1 = getPara(2);  // 通过索引值接收GET请求的方式
		System.out.println(id1);
		setAttr("msg", "接收成功");
		renderFreeMarker("param.html");

	}

	public void post(){

		String username = getPara("username");  // 这种接收方式是比较常用的
		String userpass = getPara("userpass");
		System.out.println(username);
		System.out.println(userpass);
		setAttr("msg", "接收成功");
		renderFreeMarker("param.html");
	}
}
