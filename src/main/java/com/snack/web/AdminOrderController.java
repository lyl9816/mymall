package com.snack.web;

import com.snack.pojo.OrderDetail;
import com.snack.pojo.ReceiptInfo;
import com.snack.pojo.domain.DoAdminOrder;
import com.snack.service.AdminOrderService;
import com.snack.service.impl.AdminOrderServiceImpl;
import com.snack.service.impl.UserServiceImpl;
import com.snack.utils.DataTables;
import com.snack.utils.PageHelp;
import com.snack.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/order")
public class AdminOrderController {
    @Autowired
    private AdminOrderServiceImpl adminOrderService;
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/mainToAdminOrder")
    public String mainToAdminOrder(){
        return "admin/order/adminOrder";
    }
    //订单
    @RequestMapping("/adminOrderLimit")
    @ResponseBody
    public DataTables adminOrderLimit(int start, int length,
                                      String oId, String oTimeStart, String oTimeEnd,
                                      String adUserName){
        Map<Object,Object> map=new HashMap<Object, Object>();
        map.put("pageStart",start);
        map.put("pageSize",length);
        map.put("oId",oId);
        map.put("oTimeStart",oTimeStart);
        map.put("oTimeEnd",oTimeEnd);
        map.put("adUserName",adUserName);
        PageHelp<DoAdminOrder> pageHelp=adminOrderService.selectAdminOrderLimit(map);
        DataTables dataTables=new DataTables();
        dataTables.setRecordsFiltered(pageHelp.getRecord());
        dataTables.setRecordsTotal(pageHelp.getRecord());
        dataTables.setData(pageHelp.getList());
        return dataTables;
    }
    //删除订单
    @RequestMapping("/deleteAdminOrder")
    @ResponseBody
    public String deleteAdminOrder(String oId){
        return ResponseUtil.successToClient(adminOrderService.deleteAdminOrder(oId));
    }

    //update加载订单
    @RequestMapping("/updateSelectAdminOrder")
    @ResponseBody
    public String updateSelectAdminOrder(int rId){
        return ResponseUtil.successToClient(adminOrderService.updateSelectAdminOrder(rId));
    }

    //update订单
    @RequestMapping("/updateAdminOrder")
    @ResponseBody
    public String updateAdminOrder(ReceiptInfo receiptinfo){
        return ResponseUtil.successToClient(adminOrderService.updateAdminOrder(receiptinfo));
    }

    //updateOrderDetail加载订单
    @RequestMapping("/updateSelectAdminOrderDetail")
    @ResponseBody
    public String updateSelectAdminOrderDetail(int dId){
        return ResponseUtil.successToClient(adminOrderService.updateSelectAdminOrderDetail(dId));

    }
    //updateOrderDetail订单
    @RequestMapping("/updateOrderdetail")
    @ResponseBody
    public String updateOrderdetail(OrderDetail orderDetail){
        return ResponseUtil.successToClient(adminOrderService.updateOrderDetail(orderDetail));
    }

    //删除OrderDetail
    @RequestMapping("/deleteOrderdetail")
    @ResponseBody
    public String deleteOrderdetail(int dId,String oId){
        List<OrderDetail> orderdetailList = adminOrderService.selectOrderdetailByoId(oId);
        if(orderdetailList.size()>=2){
            adminOrderService.deleteOrderBydId(dId);
            return ResponseUtil.successToClient(1);
        }else{
            adminOrderService.deleteAdminOrder(oId);
            return ResponseUtil.successToClient(2);
        }
    }
//导出订单

    //确认收货(和UserController同)
    @RequestMapping("/userOrderConfirm")
    @ResponseBody
    public String userOrderConfirm(HttpServletRequest request, int id, int typeNum){
        int eId;
        if(typeNum==0){
            eId = (Integer) request.getSession().getAttribute("adminId");
        }else{
            eId=0;
        }
        return ResponseUtil.successToClient(userService.upDateByorderConfirm(id,typeNum,eId));
    }



}
