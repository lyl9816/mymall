package com.snack.web;

import com.snack.mapper.AccountMapper;
import com.snack.pojo.Admin;
import com.snack.pojo.AdminMenu;
import com.snack.pojo.Permission;
import com.snack.service.impl.AdminLoginServiceImpl;
import com.snack.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin/login")
public class AdminLoginController {
    @Autowired
    private AdminLoginServiceImpl adminLoginService;
    @Autowired
    private AccountMapper accountMapper;

    //登录login
    @RequestMapping("/adminLogin")
    public String adminLogin(){
        //System.out.println("存储过程相加:"+accountMapper.selectNum(4, 6));
        return "admin/adminLogin";
    }
    //登录
    @RequestMapping("/adminGoLogin")
    public String adminGoLogin(HttpServletRequest request, Admin admin){
        List<Admin> adminLogin=adminLoginService.adminLogin(admin);
        if(adminLogin.size()==0){
            request.setAttribute("msg","用户名或密码错误");
            return "admin/adminLogin";
        }
        if(adminLogin.size()==1){
            request.getSession().setAttribute("adminName",adminLogin.get(0).getAdUsername());
            request.getSession().setAttribute("adminId",adminLogin.get(0).getAdId());
            //获得管理员role_id
            //request.getSession().setAttribute("roleId",adminLogin.get(0).getRoleId());
            //获得该权限的功能栏
            List<Permission> allPer=adminLoginService.selectAllPermission();
            List<Permission> userPer=adminLoginService.selectRolePermission(adminLogin.get(0).getRoleId());

            request.getSession().setAttribute("allPer",allPer);
            request.getSession().setAttribute("userPer",userPer);
        }
        //request.setAttribute("msg","用户名或密码错误");
        return "redirect:admainToMain";
    }
    //登录Main
    @RequestMapping("/admainToMain")
    public String admainToMain(HttpServletRequest request){
        request.setAttribute("adminMenu",adminLoginService.selectAllAdminMenu());
        request.setAttribute("adminMenuChild",adminLoginService.selectAllAdminMenuChild());
        return "admin/adminMain";
    }
    //退出
    @RequestMapping("adminMainToLoginOut")
    @ResponseBody
    public String adminMainToLoginOut(HttpServletRequest request){
        request.getSession().removeAttribute("adminName");
        return ResponseUtil.successToClient();
    }
}
