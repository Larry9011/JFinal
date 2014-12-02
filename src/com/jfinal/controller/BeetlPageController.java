package com.jfinal.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.model.User;
import com.jfinal.validator.UserValidator;

/**
 * User: Larry
 * Date: 2014-12-02
 * Time: 10:22
 * Version: 1.0
 */

public class BeetlPageController extends Controller {

    public void index(){
//		String sql ="select * from t_user order by id desc";
//		setAttr("objectlist",User.dao.find(sql));

        String sql = "from t_user order by id desc";
        int pageNum = getParaToInt(0,1);
        setAttr("pageNum",pageNum);
        setAttr("topicPage", User.dao.paginate(pageNum, 5, "select * ", sql));
        render("index.html");
    }

    /**
     * 去向添加User的页面
     */
    public void addUser(){

        render("adduser.html");
    }

    /**
     * 处理增加记录的方法
     */
    @Before(UserValidator.class)
    public void doAddUser(){

        User user = getModel(User.class);
//		user.set("userpass", "1234567");
        boolean flag = user.save();
        if(flag){
            redirect("/page/");//用户浏览器URL重写
        }else{
            renderText("Sorry,有些异常，插入失败");
        }
    }

    /**
     * 按照ID查询记录
     */
    public void queryUserById(){

        int id = getParaToInt(0);

        String sql = "select * from t_user where id = ? limit 1";
        User user = User.dao.findFirst(sql,id);
        setAttr("user", user);
        render("edituser.html");
    }

    /**
     * 按照ID删除记录
     */
    public void deleteById(){

        int id = getParaToInt(0);
        boolean flag = User.dao.deleteById(id);
        if(flag){
            redirect("/page/");//用户浏览器URL重写
        }else{
            renderText("Sorry,有些异常，删除失败");
        }
    }

    /**
     * 更新记录
     */
    @Before(UserValidator.class)
    public void updateUser(){
        User user = getModel(User.class);
        boolean flag = user.update();
        if(flag){
            redirect("/page/");//用户浏览器URL重写
        }else{
            renderText("Sorry,有些异常，更新失败");
        }
    }
}
