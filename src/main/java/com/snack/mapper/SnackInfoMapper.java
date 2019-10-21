package com.snack.mapper;

import com.snack.pojo.SnackInfo;
import com.snack.pojo.SnackInfoExample;
import com.snack.pojo.domain.DoSnack;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SnackInfoMapper {
    long countByExample(SnackInfoExample example);

    int deleteByExample(SnackInfoExample example);

    int deleteByPrimaryKey(Integer sId);

    int insert(SnackInfo record);

    int insertSelective(SnackInfo record);

    List<SnackInfo> selectByExample(SnackInfoExample example);

    SnackInfo selectByPrimaryKey(Integer sId);

    int updateByExampleSelective(@Param("record") SnackInfo record, @Param("example") SnackInfoExample example);

    int updateByExample(@Param("record") SnackInfo record, @Param("example") SnackInfoExample example);

    int updateByPrimaryKeySelective(SnackInfo record);

    int updateByPrimaryKey(SnackInfo record);

    //查询热销商品
    List<SnackInfo> selectHotSnack(Map<String,String>map);
    //查询最新商品
    List<SnackInfo> selectNewSnack();
    //查询分类商品
    List<SnackInfo> selectPuffing(Map<String,String>map);
    //查询下单商品
    List<DoSnack> selectOrderSnack(Map<Object,Object> map);
    //管理员查询商品限制集合
    List<SnackInfo> selectAdminSnackLimit(Map<Object,Object> map);
    //管理员查询订单记录总数
    int selectAdminSnackCount(Map<Object,Object> map);
}