package com.snack.service.impl;

import com.snack.mapper.AdminMapper;
import com.snack.mapper.AdminMenuChildMapper;
import com.snack.mapper.AdminMenuMapper;
import com.snack.mapper.PermissionMapper;
import com.snack.pojo.*;
import com.snack.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {
    @Autowired
    private AdminMapper adminDao;
    @Autowired
    private AdminMenuMapper adminMenuDao;
    @Autowired
    private AdminMenuChildMapper adminMenuChildDao;
    @Autowired
    private PermissionMapper permissionDao;

    //管理员登陆
    public List<Admin> adminLogin(Admin admin) {
        AdminExample ae=new AdminExample();
        AdminExample.Criteria criteria=ae.createCriteria();
        criteria.andAdUsernameEqualTo(admin.getAdUsername());
        criteria.andAdPasswordEqualTo(admin.getAdPassword());
        return adminDao.selectByExample(ae);
    }
    //获取管理员功能菜单
    public List<AdminMenu> selectAllAdminMenu() {
        return adminMenuDao.selectByExample(null);
    }
    //获取管理员功能菜单子菜单
    public List<AdminMenuChild> selectAllAdminMenuChild() {
        return adminMenuChildDao.selectByExample(null);
    }
    //查询全部功能栏
    public List<Permission> selectAllPermission() {
        return permissionDao.selectByExample(null);
    }
    //根据角色id获得功能栏
    public List<Permission> selectRolePermission(int roleId) {
        return permissionDao.selectRolePermission(roleId);
    }
}
