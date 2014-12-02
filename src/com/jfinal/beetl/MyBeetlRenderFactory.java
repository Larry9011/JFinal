package com.jfinal.beetl;

import com.jfinal.render.Render;
import org.beetl.ext.jfinal.BeetlRender;
import org.beetl.ext.jfinal.BeetlRenderFactory;

/**
 * User: Larry
 * Date: 2014-12-02
 * Time: 10:16
 * Version: 1.0
 */

public class MyBeetlRenderFactory extends BeetlRenderFactory {

    @Override
    public Render getRender(String view) {
        BeetlRender render = new BeetlRender(groupTemplate, view);
        return render;
    }

    @Override
    public String getViewExtension() {
        return ".html";
    }
}
