package com.snack.mapper;

import com.snack.pojo.Admin;
import com.snack.pojo.AdminExample;
import com.snack.pojo.domain.DoAdmin;
import com.snack.pojo.domain.DoAdminInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AdminMapper {
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer adId);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer adId);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    //查询管理员权限
    List<Admin> selectAdminLimit(Map<Object,Object> map);
    //计算权限管理员
    int countAdminLimit(Map<Object,Object> map);
    //根据id查询权限管理员
    DoAdmin selectAdminByOne(int adId);
    //根据name查询权限管理员
    DoAdmin selectAdminByName(String adminName);
    //更新管理员
    int updateAdminInfo(DoAdminInfo doadminInfo);
}