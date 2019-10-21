package com.snack.mapper;

import com.snack.pojo.Order;
import com.snack.pojo.OrderDetail;
import com.snack.pojo.OrderExample;
import com.snack.pojo.domain.DoAdminOrder;
import com.snack.pojo.domain.DoMyOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<DoMyOrder> selectMyOrderLimit(Map<Object,Object> map);

    List<DoMyOrder> selectMySuccessOrderLimit(Map<Object,Object> map);

    List<DoAdminOrder> selectAdminOrderLimit(Map<Object,Object> map);

    int countAdminOrder(Map<Object,Object> map);

    int deleteAdminOrder(String oId);

    int updateOrderByoId(String oId);
    //查询订单数量
    List<OrderDetail> selectPushSnackNum(int id);
}