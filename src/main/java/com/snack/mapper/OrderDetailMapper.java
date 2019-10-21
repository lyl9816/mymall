package com.snack.mapper;

import com.snack.pojo.OrderDetail;
import com.snack.pojo.OrderDetailExample;
import com.snack.pojo.domain.DoExcelOrder;
import com.snack.pojo.domain.DoSnack;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDetailMapper {
    long countByExample(OrderDetailExample example);

    int deleteByExample(OrderDetailExample example);

    int deleteByPrimaryKey(Integer dId);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    List<OrderDetail> selectByExample(OrderDetailExample example);

    OrderDetail selectByPrimaryKey(Integer dId);

    int updateByExampleSelective(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);

    int updateByExample(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);

    //查询订单
    DoSnack selectOrderdetail(int dId);

    //根据id查询订单
    List<OrderDetail> selectOrderdetailByoId(String oId);

    //查询订单支付金额
    Double selectOrderdetailPayMoney(String oId);

    List<DoExcelOrder> outExcelOrderDetail(String oId);
}