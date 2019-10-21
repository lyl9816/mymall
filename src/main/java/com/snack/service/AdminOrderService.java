package com.snack.service;

import com.snack.pojo.OrderDetail;
import com.snack.pojo.ReceiptInfo;
import com.snack.pojo.domain.DoAdminOrder;
import com.snack.pojo.domain.DoExcelOrder;
import com.snack.pojo.domain.DoSnack;
import com.snack.utils.PageHelp;

import java.util.List;
import java.util.Map;

public interface AdminOrderService {
    //加载订单
    PageHelp<DoAdminOrder> selectAdminOrderLimit(Map<Object,Object> map);
    //删除管理订单
    public int deleteAdminOrder(String oId);
    //更新加载订单
    public ReceiptInfo updateSelectAdminOrder(int rId);
    //更新订单
    public int updateAdminOrder(ReceiptInfo receiptinfo);
    //更新OrderDetail加载订单
    public DoSnack updateSelectAdminOrderDetail(int dId);
    //更新OrderDetail订单
    public int updateOrderDetail(OrderDetail orderDetail);
    //根据订单id查询订单
    public List<OrderDetail> selectOrderdetailByoId(String oId);
    //根据订单id删除订单
    public int deleteOrderBydId(int dId);
    //输出表格
    List<DoExcelOrder> outExcelOrderDetail(String oId);

}
