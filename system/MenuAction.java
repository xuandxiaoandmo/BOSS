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


    // struts框架在封装数据的时候优先封装给模型对象的
    @Action(value = "menuAction_save", results = {@Result(name = "success",
            location = "/pages/system/menu.html", type = "redirect")})
    public String save() {时候优先封装给模型对象的
    @Action(value = "menuAction_pageQuery")
    public String pageQuery()
                new String[] {"roles", "childrenMenus", "parentMenu"});
        page2json(page, jsonConfig);
    public String pageQuery() throws IOException {

        // EasyUI的页码是从1开始的
        // SPringDataJPA的页码是从0开始的
        // 所以要-1


        Page<Menu> page = menuService.findAll(pageable);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(
       
        page2json(page, jsonConfig);
        return NONE;
    }

    @Action(value = "menuAction_findbyUser")
    public String findbyUser() throws IOException {
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();

      
      

        list2json(list, jsonConfig);
        return NONE;
    }
    
}
