package com.snack.mapper;

import com.snack.pojo.AdminMenuChild;
import com.snack.pojo.AdminMenuChildExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMenuChildMapper {
    long countByExample(AdminMenuChildExample example);

    int deleteByExample(AdminMenuChildExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdminMenuChild record);

    int insertSelective(AdminMenuChild record);

    List<AdminMenuChild> selectByExample(AdminMenuChildExample example);

    AdminMenuChild selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdminMenuChild record, @Param("example") AdminMenuChildExample example);

    int updateByExample(@Param("record") AdminMenuChild record, @Param("example") AdminMenuChildExample example);

    int updateByPrimaryKeySelective(AdminMenuChild record);

    int updateByPrimaryKey(AdminMenuChild record);
}