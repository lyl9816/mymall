package com.snack.service;

import com.snack.pojo.Admin;
import com.snack.pojo.UserInfo;
import com.snack.pojo.domain.DoAdmin;
import com.snack.utils.PageHelp;

import java.util.Map;

public interface AdminUserService {

    //管理员查询用户权限
    public PageHelp<UserInfo> selectAdminUserinfoLimit(Map<Object,Object> map, UserInfo userinfo);
    //根据id删除用户
    public int delUserInfoById(int uId);
    //根据id选择更新用户
    public UserInfo updateGoUserinfoById(Integer uId);
    //修改用户
    int updateUserinfoById(UserInfo userinfo);
    //查询管理员权限
    PageHelp<Admin> selectAdminLimit(Map<Object,Object> map, DoAdmin doAdmin);
    //添加管理员
    int addAdmin(Admin admin);
    //删除管理员
    int delAdmin(Admin admin);
    //根据id查询权限管理员
    DoAdmin selectAdminByOne(Admin admin);
    //根据name查询权限管理员
    DoAdmin selectAdminByName(String adminName);
    //更新管理员
    int updateAdmin(Admin admin);
}
