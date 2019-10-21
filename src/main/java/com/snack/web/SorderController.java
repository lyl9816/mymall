package com.snack.web;

import com.snack.pojo.*;
import com.snack.pojo.domain.DoMoneyFK;
import com.snack.service.impl.SorderServiceImpl;
import com.snack.service.impl.UserServiceImpl;
import com.snack.utils.DateUtil;
import com.snack.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Controller
@RequestMapping("/sorder")
public class SorderController {

    @Autowired
    private SorderServiceImpl sorderService;
    @Autowired
    private UserServiceImpl userService;

    //增加商品订单post
    @RequestMapping(value = "/add")//,method = RequestMethod.GET
    public String addSorder(SnackInfo snackInfo, HttpSession session){
        System.out.println("addSorder------------------------------------------");
        //找到商品
//        snackInfo.setsId(20);
//        snackInfo.setsName("可乐");
        SnackInfo findSnackInfo=sorderService.findSnackById(snackInfo);
        findSnackInfo.setsNumber(snackInfo.getsNumber());
        //判断session是否有购物车
        if(session.getAttribute("receiptinfo")==null){
            //创建购物车
            session.setAttribute("receiptinfo",new ReceiptInfo(new HashSet< OrderDetail >()));
        }
        //获取购物车
        ReceiptInfo receiptInfo= (ReceiptInfo) session.getAttribute("receiptinfo");
        //把商品转为sorder加到购物车
        receiptInfo=sorderService.addSorder(receiptInfo,findSnackInfo);
        receiptInfo.setoPhone(cluTotal(receiptInfo));
        //-----------------------------------------------
        return "redirect:gotoCar";
    }
    //计算总金额
    public String cluTotal(ReceiptInfo receiptinfo) {

        double tal=0.0;
        for(OrderDetail temp : receiptinfo.getOrderdetailSet()){

            tal+=temp.getoMoney()*temp.getoNum();
        }

        return String.valueOf(tal);
    }
    //转到购物车
    @RequestMapping("/gotoCar")
    public  String gotoCar(){
        return "product/car";
    }

    //计算总金额
    public String countTotal(ReceiptInfo receiptInfo){
        double total=0.0;
        for(OrderDetail re:receiptInfo.getOrderdetailSet()){
            total+=re.getoMoney()*re.getoNum();
        }
        return String.valueOf(total);
    }
    //删除sorder
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    public String deleteSorder(SnackInfo snackInfo,HttpSession session){
        //获取当前购物车清单
        ReceiptInfo receiptInfo= (ReceiptInfo) session.getAttribute("receiptinfo");
        Set<OrderDetail> set=receiptInfo.getOrderdetailSet();
        Iterator<OrderDetail> iterator=set.iterator();
        while (iterator.hasNext()){
            OrderDetail orderDetail=iterator.next();
            //比对购物车里商品id和传入id
            if(orderDetail.getSnackinfo().getsId().equals(snackInfo.getsId())){
                iterator.remove();
                //----------------------------------
            }
        }
        if( set.size() <= 0){
            session.removeAttribute("receiptinfo");
        }
        return "redirect:gotoCar";
    }
    //clearSorder
    @RequestMapping(value="/clear",method=RequestMethod.GET)
    public String clearSorder(SnackInfo snackInfo,HttpSession session){
        ReceiptInfo receiptInfo= (ReceiptInfo) session.getAttribute("receiptinfo");
        if(receiptInfo!=null){
            Set<OrderDetail> set=receiptInfo.getOrderdetailSet();
            set.clear();
        }
        //----------------------
        session.removeAttribute("receiptinfo");
        return "redirect:gotoCar";
    }

    //下订单
    @RequestMapping("/setOrder")
    @ResponseBody
    public String setOrder(HttpServletRequest request,HttpSession session,
                           ReceiptInfo receiptInfo){
        //创建流水
        DoMoneyFK doMoneyFK=new DoMoneyFK();
        //获取当前购物车
        ReceiptInfo recSession= (ReceiptInfo) session.getAttribute("receiptinfo");
        System.out.println("recSession============:"+receiptInfo);
        //用日期设置id
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String oId=df.format(day).toString()+String.valueOf((int)(Math.random()*9000+1000));
        //设置订单id及订单内容
        receiptInfo.setoId(oId);
        receiptInfo.setOrderdetailSet(recSession.getOrderdetailSet());
        //增加至receiptInfo
        sorderService.addReceiptInfo(receiptInfo);

        //获取订单
        Order order=new Order();
        order.setoId(oId);
        order.setuId((Integer) session.getAttribute("frontuserId"));//获取前端用户id
        order.setoTime(DateUtil.getCurrentTime());//获取当前时间
        order.setoType(-1);
        //添加至Order
        sorderService.addOrder(order);

//        request.getSession().getAttribute("orderdetail.snackinfo.sId");
//        System.out.println("----------------------下订单里的snackId："+
//                request.getSession().getAttribute("orderdetail.snackinfo.sId"));
        //获取订单详情
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setoId(oId);
        for(OrderDetail ordSession:recSession.getOrderdetailSet()){
            orderDetail.setoMoney(ordSession.getoMoney());//绑定订单金额
            orderDetail.setoNum(ordSession.getoNum());//绑定订单数量
//            System.out.println("123:"+ordSession.getsId());
            orderDetail.setsId(ordSession.getsId());//绑定商品id
//            System.out.println("sid:"+orderDetail.getsId());
            //添加至orderDetail
            sorderService.addOrderDetail(orderDetail);
        }
        //获得账户金额及支付金额
        UserInfo selectUserinfoMoney=userService.selectUserInfoMoney((Integer) session.getAttribute("frontuserId"));
        Double selectOrderdetailPayMoney=sorderService.selectOrderedMoney(oId);
        //设置流水属性
        doMoneyFK.setoId(oId);
        doMoneyFK.setuMoney(selectUserinfoMoney.getuMoney());
        doMoneyFK.setPayMoney(selectOrderdetailPayMoney.toString());
        request.getSession().setAttribute("doMoneyFK",doMoneyFK);
       // System.out.println();

        session.removeAttribute("receiptinfo");
        return ResponseUtil.successToClientStr(doMoneyFK);//返回成功数据
    }
}
