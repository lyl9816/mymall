package com.snack.service.impl;

import com.snack.mapper.OrderDetailMapper;
import com.snack.mapper.OrderMapper;
import com.snack.mapper.ReceiptInfoMapper;
import com.snack.mapper.SnackInfoMapper;
import com.snack.pojo.Order;
import com.snack.pojo.OrderDetail;
import com.snack.pojo.ReceiptInfo;
import com.snack.pojo.SnackInfo;
import com.snack.service.SorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SorderServiceImpl implements SorderService {

    @Autowired
    private SnackInfoMapper snackInfoDao;
    @Autowired
    private ReceiptInfoMapper receiptInfoDao;
    @Autowired
    private OrderMapper orderDao;
    @Autowired
    private OrderDetailMapper orderDetailDao;

    //将商品转为订单
    public OrderDetail snackIntoOrder(SnackInfo snackInfo) {
        OrderDetail orderDetail=new OrderDetail();
        //将商品属性转为订单属性
        orderDetail.setsName(snackInfo.getsName());
        orderDetail.setsId(snackInfo.getsId());
        orderDetail.setoNum(snackInfo.getsNumber());
        orderDetail.setoMoney(snackInfo.getsPrice()*Double.parseDouble(snackInfo.getsDiscount())*0.1);
        orderDetail.setSnackinfo(snackInfo);

        return orderDetail;
    }
    //查询商品
    public SnackInfo findSnackById(SnackInfo snackInfo) {
        return snackInfoDao.selectByPrimaryKey(snackInfo.getsId());
    }
    //增加购物车订单
    public ReceiptInfo addSorder(ReceiptInfo receiptinfo, SnackInfo snackinfo) {
        boolean isHave=false;
        OrderDetail orderDetail=snackIntoOrder(snackinfo);
        for(OrderDetail oldorderDetail:receiptinfo.getOrderdetailSet()){
            //若商品id重复则数量加一
            if(oldorderDetail.getSnackinfo().getsId().equals(orderDetail.getSnackinfo().getsId())){
                oldorderDetail.setoNum(orderDetail.getoNum()+orderDetail.getoNum());
                oldorderDetail.setoMoney(orderDetail.getoMoney());
                isHave=true;
                break;
            }

        }
        //若购物车无此商品，增加
        if(!isHave){
            receiptinfo.getOrderdetailSet().add(orderDetail);
        }
        return receiptinfo;
    }
    //添加收货信息
    public int addReceiptInfo(ReceiptInfo receiptinfo) {
        return receiptInfoDao.insertSelective(receiptinfo);
    }
    //添加订单信息
    public int addOrder(Order order) {
        return orderDao.insertSelective(order);
    }
    //添加订单商品
    public int addOrderDetail(OrderDetail orderDetail) {
        return orderDetailDao.insertSelective(orderDetail);
    }
    //支付金额
    public double selectOrderedMoney(String oId) {
        return orderDetailDao.selectOrderdetailPayMoney(oId);
    }


    //未付款到已付款
    public int updateOrderedByoId(String oId) {
        return orderDao.updateOrderByoId(oId);
    }
}
