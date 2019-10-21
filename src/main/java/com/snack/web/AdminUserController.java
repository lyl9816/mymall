package com.snack.web;

import com.snack.mapper.AdminMapper;
import com.snack.pojo.Admin;
import com.snack.pojo.UserInfo;
import com.snack.pojo.domain.DoAdmin;
import com.snack.service.impl.AdminUserServiceImpl;
import com.snack.utils.DataTables;
import com.snack.utils.PageHelp;
import com.snack.utils.ResponseUtil;
import com.sun.istack.internal.Nullable;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {
    @Autowired
    private AdminUserServiceImpl adminUserService;
    @Autowired
    HttpServletRequest request;


    @RequestMapping("/mainToUserinfo")
    public String mainToUserinfo(){
        return "/admin/user/adminUserinfo";
    }
    //加载用户
    @RequestMapping("/adminUserinfoLimit")
    @ResponseBody
    public DataTables adminUserinfoLimit (HttpServletRequest request, int start, int length,
                                          UserInfo userInfo){
        Map<Object,Object> map=new HashMap<Object, Object>();
        map.put("pageStart",start);
        map.put("pageSize",length);
        PageHelp<UserInfo> pageHelp=adminUserService.selectAdminUserinfoLimit(map,userInfo);
        DataTables dataTables=new DataTables();
        dataTables.setRecordsFiltered(pageHelp.getRecord());
        dataTables.setRecordsTotal(pageHelp.getRecord());
        dataTables.setData(pageHelp.getList());
        return dataTables;
    }
    //删除用户
    @RequestMapping("/delUserinfoById")
    @ResponseBody
    public String delUserinfoById(HttpServletRequest request,int uId){
        //获取前端登录管理员
        String adminName= (String) request.getSession().getAttribute("adminName");
        //System.out.println("===========adminName:"+adminName);
        //管理员对象
        DoAdmin doAdmin=adminUserService.selectAdminByName(adminName);
        //System.out.println("----------------domainRoleId:"+doAdmin.getRoleId());
        //根据权限删除用户
        String s=null;
        if(doAdmin.getRoleId()==1){//有权限
            s=ResponseUtil.successToClient(adminUserService.delUserInfoById(uId));
        }else{
            s=ResponseUtil.errorToClient();
        }
        return s;
    }
    //更新用户
    @RequestMapping("/updateGoUserinfoById")
    @ResponseBody
    public String updateGoUserinfoById(UserInfo userinfo){
        //System.out.println("========= updateUserinfo:"+userinfo);
        //System.out.println("========= updateUserinfo:"+userinfo.getuId());
        //request.setAttribute("uId",userinfo.getuId());
        return ResponseUtil.successToClient(adminUserService.updateGoUserinfoById(userinfo.getuId()));
    }
    //更新加载用户
    @RequestMapping("/updateUserinfoById")
    @ResponseBody
    public String updateUserinfoById(UserInfo userinfo){
        //System.out.println("=============UID:"+userinfo.getuId());
        return ResponseUtil.successToClient(adminUserService.updateUserinfoById(userinfo));
    }

    @RequestMapping("/mainToAdmin")
    public String mainToAdmin(){
        return "/admin/user/adminAdmin";
    }

    @RequestMapping("/adminAdminLimit")
    @ResponseBody
    public DataTables adminAdminLimit(HttpServletRequest request,int start,int length,DoAdmin doAdmin){
        Map<Object,Object> map=new HashMap<Object, Object>();
        map.put("pageStart",start);
        map.put("pageSize",length);
        PageHelp<Admin> pageHelp=adminUserService.selectAdminLimit(map,doAdmin);
        DataTables dataTables=new DataTables();
        dataTables.setRecordsTotal(pageHelp.getRecord());
        dataTables.setRecordsFiltered(pageHelp.getRecord());
        dataTables.setData(pageHelp.getList());
        return dataTables;
    }
    //添加管理员
    @RequestMapping("/addNewAdmin")
    @ResponseBody
    public String addAdmin(Admin admin){
        return ResponseUtil.successToClient(adminUserService.addAdmin(admin));
    }
    //删除管理员
    @RequestMapping("/delAdminById")
    @ResponseBody
    public String delAdmin(Admin admin){
        //获取前端登录管理员
//        String adminName= (String) request.getSession().getAttribute("adminName");
        //System.out.println("===========adminName:"+adminName);
        //管理员对象
//        DoAdmin doAdmin=adminUserService.selectAdminByName(adminName);
        System.out.println("----------------AdminRoleId:"+admin.getRoleId());
        //根据权限删除管理员
        String s=null;
        if(admin.getRoleId()==1){//有权限
            s=ResponseUtil.successToClient(adminUserService.delAdmin(admin));
        }else{
            s=ResponseUtil.errorToClient();
        }
        return s;
    }
    //更新加载用户
    @RequestMapping("/updateGoAdminById")
    @ResponseBody
    public String updateGoAdminById(Admin admin){
        return ResponseUtil.successToClient(adminUserService.selectAdminByOne(admin));
    }
    //更新用户
    @RequestMapping("/updateAdminById")
    @ResponseBody
    public String updateAdmin(Admin admin){
        return ResponseUtil.successToClient(adminUserService.updateAdmin(admin));
    }
}
