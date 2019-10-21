package com.snack.service;

import com.snack.pojo.Order;
import com.snack.pojo.OrderDetail;
import com.snack.pojo.ReceiptInfo;
import com.snack.pojo.SnackInfo;

public interface SorderService {
    //将商品转为订单
    public OrderDetail snackIntoOrder(SnackInfo snackInfo);
   //查询商品
    public SnackInfo findSnackById(SnackInfo snackInfo);
    //增加购物车订单
    public ReceiptInfo addSorder(ReceiptInfo receiptinfo, SnackInfo snackinfo);
    //添加收货信息
    public int addReceiptInfo (ReceiptInfo receiptinfo);
    //添加订单信息
    public int addOrder(Order order);
    //添加订单商品
    public int addOrderDetail(OrderDetail orderDetail);
    //支付金额
    public double selectOrderedMoney(String oId);
    //未付款到已付款
    public int updateOrderedByoId(String oId);

}
