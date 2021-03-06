package com.jfinal.common;

import com.jfinal.beetl.MyBeetlRenderFactory;
import com.jfinal.config.*;
import com.jfinal.controller.*;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.interceptor.GlobalTestInterceptor;
import com.jfinal.kit.PathKit;
import com.jfinal.model.Login;
import com.jfinal.model.User;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import org.beetl.core.GroupTemplate;

/**
 * 配置类
 * User: Larry
 * Date: 2014-12-01
 * Time: 10:00
 * Version: 1.0
 */

public class Config extends JFinalConfig {
    @Override
    public void configConstant(Constants me) {
        loadPropertyFile("jdbc.txt");    // 加载数据库配置信息
        me.setDevMode(getPropertyToBoolean("devMode", true));
//        me.setViewType(ViewType.FREE_MARKER);

        //配置模板
        me.setMainRenderFactory(new MyBeetlRenderFactory());
        //获取GroupTemplate模板，可以设置共享变量操作
        GroupTemplate groupTemplate=MyBeetlRenderFactory.groupTemplate;
//        me.setDevMode(getPropertyToBoolean("config.devModel", false));
        me.setViewType(ViewType.JSP);
        me.setEncoding("UTF-8");

        // 设置文件上传路径
        PathKit fk = new PathKit();
        String contextPath = fk.getWebRootPath();
        me.setUploadedFileSaveDirectory(contextPath + "/uploadfiles");
    }

    @Override
    public void configRoute(Routes me) {
        me.add("/hello", HelloWorldController.class,"/user");
        me.add("/param", GetParameterController.class,"/pages/param");
//        me.add("/user", UserController.class,"/pages/user");
        me.add("/interceptor", InterceptorController.class);
        me.add("/upload", UploadController.class,"/pages/upload");
        me.add("/page",BeetlPageController.class,"/common");
        me.add("/",BeetlUserController.class,"/user");
    }

    @Override
    public void configPlugin(Plugins me) {
        String decPassWord = getProperty("password");
        String decUser = getProperty("user");
        DruidPlugin druid = new DruidPlugin(getProperty("jdbcUrl"), decUser, decPassWord);
        me.add(druid);  // 添加连接池
        ActiveRecordPlugin arp = new ActiveRecordPlugin(druid);
        me.add(arp);   // 接入ActiveRecord插件
        arp.setShowSql(true);  // 调试阶段，查看SQL语句
        arp.addMapping("t_user", User.class);  // 将实体和表映射
        arp.addMapping("user", Login.class);  // 将实体和表映射
    }

    @Override
    public void configInterceptor(Interceptors me) {
        me.add(new GlobalTestInterceptor());  // 定义一个全局拦截器
    }

    @Override
    public void configHandler(Handlers me) {
        me.add(new ContextPathHandler("contextPath"));  // 设置上下文路径
    }
}
