package com.jfinal.controller;

import com.jfinal.common.Encrypt;
import com.jfinal.core.Controller;
import com.jfinal.model.Login;
import com.jfinal.model.User;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * User: Larry
 * Date: 2014-12-02
 * Time: 10:22
 * Version: 1.0
 */

public class BeetlUserController extends Controller {

    public void index() {
        render("index.html");
    }

    public void loginpage(){
        render("login.html");
    }

    public void login() {
        String uname = getPara("user.uname");
        String pwd = Encrypt.md5(getPara("user.pwd"));
        List<Login> l = Login.login.find("select id,nickname from user where uname='"
                + uname + "' and pwd='" + pwd + "'");

        if (l.size() > 0) {
//            HttpSession session = getSession();
            String nickname = l.get(0).getStr("nickname");
            if (nickname != null && !("").equals(nickname)) {
//                session.setAttribute("uname", nickname);
                setSessionAttr("uname",nickname);
            } else {
//                session.setAttribute("uname", uname);
                setSessionAttr("uname",uname);
            }
//            session.setAttribute("uid", l.get(0).get("id"));
            setSessionAttr("uid",l.get(0).get("id"));
            setAttr("msg", "登陆成功");
            render("index.html");
        } else {
            setAttr("msg", "用户名或者密码错误");
            render("login.html");
        }
    }

    public void logout() {
        removeSessionAttr("uname");
        removeSessionAttr("uid");
        redirect("/index.html");
    }

    public void register() {
        render("register.html");
    }
}
