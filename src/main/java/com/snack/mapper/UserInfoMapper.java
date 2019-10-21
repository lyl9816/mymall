package com.snack.mapper;

import com.snack.pojo.UserInfo;
import com.snack.pojo.UserInfoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface UserInfoMapper {
    long countByExample(UserInfoExample example);//按条件计数

    int deleteByExample(UserInfoExample example);//按条件删除

    int deleteByPrimaryKey(Integer uId);//按主键删除

    int insert(UserInfo record);//插入数据（返回值为ID）

    int insertSelective(UserInfo record);//插入数据值不为null的字段

    List<UserInfo> selectByExample(UserInfoExample example);//按条件查询

    UserInfo selectByPrimaryKey(Integer uId);//按主键查询

    //按条件更新值不为null的字段
    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    //按条件更新
    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByPrimaryKeySelective(UserInfo record);//按主键更新值不为null的字段

    int updateByPrimaryKey(UserInfo record);//按主键更新

    UserInfo selectUserLogin(UserInfo userinfo);//查询登录

    UserInfo selectUserOne(UserInfo userinfo);////注册判断用户名存在

    List<UserInfo> selectUserinfoLimit(Map<Object,Object> map);
}
