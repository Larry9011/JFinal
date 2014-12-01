package com.jfinal.controller;

import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;

public class UploadController extends Controller {

	public void index(){
		renderFreeMarker("upload.html");
	}

	/**
	 * 去向文件上传页面
	 */
	public void upload(){
		renderFreeMarker("upload.html");
	}

	/**
	 * 处理文件上传
	 */
	public void doUpload(){

		UploadFile uf = getFile("filename","test/");//接收上传文件的一个方法

		System.out.println(uf);
		//如何获取带有文件上传的表单中的非文件元素数据
		String title = getPara("title");
		//在平时我们使用这样的方式接收参数，是能够接收到我们表单中对应的数据的
		System.out.println(title);
		renderText("success");
	}
}
