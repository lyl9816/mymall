package com.snack.service;

import com.snack.pojo.Admin;
import com.snack.pojo.AdminMenu;
import com.snack.pojo.AdminMenuChild;
import com.snack.pojo.Permission;

import java.util.List;

public interface AdminLoginService {
    //管理员登陆
    List<Admin> adminLogin(Admin admin);
    //获取管理员功能菜单
    List<AdminMenu> selectAllAdminMenu();
    //获取管理员功能菜单子菜单
    List<AdminMenuChild> selectAllAdminMenuChild();
    //查询全部功能栏
    List<Permission> selectAllPermission();
    //根据角色id获得功能栏
    List<Permission> selectRolePermission(int roleId);


}
