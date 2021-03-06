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
    @Action(value = "roleAction_pageQuery")
    public String pageQuery() throws IOException {

        // EasyUI的页码是从1开始的
        // SPringDataJPA的页码是从0开始的
        // 所以要-1

        Pageable pageable = new PageRequest(page - 1, rows);

       
        return NONE;
    }

    // 使用属性驱动获取菜单和权限的ID
    private String menuIds;

    public void setMenuIds(String menuIds) {
        this.menuIds = menuIds;
    }

    private Long[] permissionIds;

    public void setPermissionIds(Long[] permissionIds) {
        this.permissi
        this.permissionIds = permissionIds;
    }

  
        roleService.save(getModel(), menuIds, permissionIds);
        return SUCCESS;
    }
    
    //修改
    @Action(value = "roleAction_edit", results = {@Result(name = "success",
            location = "/pages/system/role.html", type = "redirect")})
    public String edit() {
        System.out.println("menuIds=="+menuIds+"===permissionIds"+permissionIds+"id=="+getModel().getId());
        roleService.edit(getModel(), menuIds, permissionIds);
        return SUCCESS;
    }
        Page<Role> page = roleService.findAll(null);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[] {"users","menus","permissions"});

        List<Role> list = page.getContent();
        list2json(list, jsonConfig);
        return NONE;
    }
    
    //根据角色ID获.println("角色ID="+id);
        
        List<Permission> list =roleService.findByRoleId(id);
        System.out.println("权限IDS="+list);
        
       JsonConfig jsonConfig=new JsonConfig();
       jsonConfig.setExcludes(new String[] {"roles"});
       list2json(list, jsonConfig);
        
        return NONE;
    }
    
    //根据角色ID获取Excludes(new String[]{"roles","childrenMenus","parentMenu"});
    //根据角色ID获取菜单
    @Action(value="roleAction_findByRoleId4Ztree")
    public Stringt.println("角色ID==菜单="+id);
        
        List<Menu> lsonConfig=new JsonConfig();
        jsonConfig.setExcludes(new String[]{"roles","childrenMenus","parentMenu"});
        list2json(list, jsonConfig);
        return NONE;
    }
    
}
