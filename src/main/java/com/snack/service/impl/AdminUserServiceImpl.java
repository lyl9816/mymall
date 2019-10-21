package com.snack.service.impl;

import com.snack.mapper.AdminMapper;
import com.snack.mapper.UserInfoMapper;
import com.snack.pojo.*;
import com.snack.pojo.domain.DoAdmin;
import com.snack.service.AdminUserService;
import com.snack.utils.PageHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminMapper adminDao;
    @Autowired
    private UserInfoMapper userInfoDao;

    //管理员查询用户权限
    public PageHelp<UserInfo> selectAdminUserinfoLimit(Map<Object, Object> map, UserInfo userinfo) {
        map.put("userinfo",userinfo);
        PageHelp<UserInfo> pageHelp=new PageHelp<UserInfo>();
        List<UserInfo> selectUserinfoLimit=userInfoDao.selectUserinfoLimit(map);

        UserInfoExample ue=new UserInfoExample();
        UserInfoExample.Criteria cr=ue.createCriteria();
        if(""!=userinfo.getuUsername() && null!=userinfo.getuUsername()){
            cr.andUUsernameEqualTo(userinfo.getuUsername());
        }
        if(""!=userinfo.getuPhone() && null!=userinfo.getuPhone()){
            cr.andUPhoneEqualTo(userinfo.getuPhone());
        }
        //按ue条件查询结果
        int countByExample= (int) userInfoDao.countByExample(ue);
        //把数据和结果数量存入pageHelp
        pageHelp.setList(selectUserinfoLimit);
        pageHelp.setRecord(countByExample);
        return pageHelp;
    }
    //根据id删除用户
    public int delUserInfoById(int uId) {
        return userInfoDao.deleteByPrimaryKey(uId);
    }
    //根据id选择更新用户
    public UserInfo updateGoUserinfoById(Integer uId) {
        return userInfoDao.selectByPrimaryKey(uId);
    }
    //修改用户
    public int updateUserinfoById(UserInfo userinfo) {
        return userInfoDao.updateByPrimaryKey(userinfo);
    }
    //查询管理员权限
    public PageHelp<Admin> selectAdminLimit(Map<Object,Object> map, DoAdmin doAdmin) {
        map.put("admin",doAdmin);
        List<Admin> doAdminList=adminDao.selectAdminLimit(map);
        PageHelp<Admin> pageHelp=new PageHelp<Admin>();
        int countAdminLimit=adminDao.countAdminLimit(map);

        pageHelp.setList(doAdminList);
        pageHelp.setRecord(countAdminLimit);
        return pageHelp;
    }
    //添加管理员
    public int addAdmin(Admin admin) {
        return adminDao.insert(admin);
    }
    //删除管理员
    public int delAdmin(Admin admin) {
        return adminDao.deleteByPrimaryKey(admin.getAdId());
    }
    //根据id查询权限管理员
    public DoAdmin selectAdminByOne(Admin admin) {
        return adminDao.selectAdminByOne(admin.getAdId());
    }
    //根据name查询权限管理员
    public DoAdmin selectAdminByName(String adminName) {
        return adminDao.selectAdminByName(adminName);
    }

    //更新管理员
    public int updateAdmin(Admin admin) {
        return adminDao.updateByPrimaryKey(admin);
    }
}
