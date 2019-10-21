package com.snack.service.impl;

import com.snack.mapper.OrderDetailMapper;
import com.snack.mapper.OrderMapper;
import com.snack.mapper.ReceiptInfoMapper;
import com.snack.pojo.OrderDetail;
import com.snack.pojo.ReceiptInfo;
import com.snack.pojo.domain.DoAdminOrder;
import com.snack.pojo.domain.DoExcelOrder;
import com.snack.pojo.domain.DoSnack;
import com.snack.service.AdminOrderService;
import com.snack.utils.PageHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminOrderServiceImpl implements AdminOrderService {
    @Autowired
    public OrderMapper orderDao;
    @Autowired
    public ReceiptInfoMapper receiptInfoDao;
    @Autowired
    public OrderDetailMapper orderDetailDao;

    public PageHelp<DoAdminOrder> selectAdminOrderLimit(Map<Object, Object> map) {
        PageHelp<DoAdminOrder> pageHelp=new PageHelp<DoAdminOrder>();
        List<DoAdminOrder> selectAdminOrderList=orderDao.selectAdminOrderLimit(map);
        int countAdminOrder=orderDao.countAdminOrder(map);
        pageHelp.setList(selectAdminOrderList);
        pageHelp.setRecord(countAdminOrder);
        return pageHelp;
    }

    public int deleteAdminOrder(String oId) {
        return orderDao.deleteAdminOrder(oId);
    }

    public ReceiptInfo updateSelectAdminOrder(int rId) {
        return receiptInfoDao.selectByPrimaryKey(rId);
    }

    public int updateAdminOrder(ReceiptInfo receiptinfo) {
        return receiptInfoDao.updateByPrimaryKeySelective(receiptinfo);
    }

    public DoSnack updateSelectAdminOrderDetail(int dId) {
        return orderDetailDao.selectOrderdetail(dId);
    }

    public int updateOrderDetail(OrderDetail orderDetail) {
        return orderDetailDao.updateByPrimaryKey(orderDetail);
    }

    public List<OrderDetail> selectOrderdetailByoId(String oId) {
        return orderDetailDao.selectOrderdetailByoId(oId);
    }

    public int deleteOrderBydId(int dId) {
        return orderDetailDao.deleteByPrimaryKey(dId);
    }

    public List<DoExcelOrder> outExcelOrderDetail(String oId) {
        return orderDetailDao.outExcelOrderDetail(oId);
    }
}
