package com.itheima.bos.web.action.base;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
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

import com.itheima.bos.domain.base.FixedArea;
import com.itheima.bos.service.base.FixedAreaService;
import com.itheima.bos.web.action.CommonAction;
import com.itheima.crm.domain.Customer;

import net.sf.json.JsonConfig;

/**
 * ClassName:StandardAction <br/>
 * Function: <br/>
 * Date: 2018年3月14日 上午8:52:21 <br/>
 */
@Namespace("/") // 等价于struts.xml文件中package节点namespace属性
@ParentPackage("struts-default") // 等价于struts.xml文件中package节点extends属性
@Controller // spring 的注解,控制层代码
@Scope("protixedAreaService fixedAreaService;

    @Action(value = "fixedAreaAction_save", results = {@Result(name = "success",
            location = "/pages/base/fixed_area.html", type = "redirect")})
    public String save() {

        fixedAreUCCESS;
    
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[] {"subareas", "couriers" });

        page2json(page, jsonConfig);
        return NONE;
    }

    // 向CRM系统发起请求,查询未关联定区的客户
    @Action(value = "fixedAreaAction_findUnAssociatedCustomers")
    public String findUnAssociatedCustomers() throws IOException {

        List<Customer> list = (List<Customer>) WebClient.create(
                "http://localhost:8180/crm/webService/customerService/findCustomersUnAssociated")
                .type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .getCollection(Customer.c
    }

    // 向CRM系统发起请求,关联客户
    @Action(value = "fixedAreaAction_assignCustomers2FixedArea",
            results = {@Result(name = "success",
                    location = "/pages/base/fixed_area.html",
                    type = "redirect")})
    public String assignCustomers2FixedArea() throws IOException {
        if (customerIds == null || customerIds.length == 0) {
            customerIds = new Long[]{0l};
        }
        WebClient.create(
                "http://localhost:8180/crm/webService/customerService/assignCustomers2FixedArea")
                .query("fixedAreaId", getModel().getId())
                .query("customerIds", customerIds)
                .type(MediaType.APPLICATION_JSON)
                .accept(Med
    // 关联快递员
    @Action(value = "fixedAreaAction_associationCourierToFixedArea",
            results = {@Result(name = "success",
                    location = "/pages/base/fixed_area.html",
                    type = "redirect"

    // 使用属性驱动获取分区的Id
    private Long[] subAreaIds;

    public void setSubAreaIds(Long[] subAreaIds) {
        this.subAreaIds = subAreaIds;
    }

    // 关联分区
