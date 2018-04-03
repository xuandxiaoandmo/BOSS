package com.itheima.bos.web.action.system;

import java.io.IOException;
import java.util.List;

import javax.jws.WebParam.Mode;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springfr
import net.sf.json.JsonConfig;

/**
 * ClassName:RoleAction <br/>
 * Function: <br/>
 * Date: 2018年3月28日 上午10:55:04 <br/>
 */
@Namespace("/") // 等价于struts.xml文件中package节点namespace属性
@ParentPackage("struts-default") // 等价于struts.xml文件中package节点extends属性
@Controller // spring 的注解,控制层代码
@Scope("prototype") // spring 的注解,多例
public class RoleAction extends CommonAction<Role> {

    public RoleAction() {
        super(Role.class);
    }

    @Autowired
    private RoleService roleService;
     return NONE;
    }

    // 使用属性驱动获取菜单和权限的ID
    private String menuIds;

    public void setMenuIds(String menuIds) {
        this.menuIds = menuIds;
    }

   

    public void setPermissionIds(Long[] permissionIds) {
        this.permissi
        List<Permission> list =roleService.findByRoleId(id);
        System.out.println("权限IDS="+list);
        
       JsonConfig jsonConfig=new JsonConfig();
       jsonConfig.setExcludes(new String[] {"roles"});
       list2json(list, jsonConfig);
        
        return NONE;
    }
    
    //根据角色ID获取Excludes(new String[]{"roles","childrenMenus","parentMenu"});
        list2json(list, jsonConfig);
        return NONE;
    }
    
}
