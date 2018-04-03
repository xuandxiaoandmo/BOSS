package com.itheima.bos.web.action.system;

import java.io.IOException;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domr/>
 * Function: <br/>解
    }

    @Action(value = "menuAction_save", results = {@Result(name = "success",
            location = "/pages/system/menu.html", type = "redirect")})
    public String save() {时候优先封装给模型对象的
    @Action(value = "menuAction_pageQuery")
    public String pageQuery()
                new String[] {"roles", "childrenMenus", "parentMenu"});
        page2json(page, jsonConfig);
        Page<Menu> page = menuService.findAll(pageable);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(
        return NONE;
    }

    @Action(value = "menuAction_findbyUser")
    public String findbyUser() throws IOException {
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();

        List<Menu> list = menuService.findbyUser(user);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(
                new String[] {"roles", "childrenMenus", "parentMenu","children"});

        list2json(list, jsonConfig);
        return NONE;
    }
    
}
