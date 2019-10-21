package com.snack.web;

import com.snack.pojo.UserInfo;
import com.snack.pojo.domain.DoAdminInfo;
import com.snack.pojo.domain.DoMyOrder;
import com.snack.pojo.domain.DoPayMoney;
import com.snack.service.AdminOrderService;
import com.snack.service.SorderService;
import com.snack.service.impl.UserServiceImpl;
import com.snack.utils.AjaxResult;
import com.snack.utils.DataTables;
import com.snack.utils.PageHelp;
import com.snack.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private SorderService sorderService;
    @Autowired
    private AdminOrderService adminOrderService;

    //跳转注册
    @RequestMapping("/userRegisterGet")
    public String gotoRegister(){
        return "user/register";
    }
    //注册判断用户名存在
    @RequestMapping("/selectUserOne")
    @ResponseBody
    public AjaxResult getUserOne(UserInfo userInfo){
        AjaxResult aj=new AjaxResult();
        UserInfo rs = userService.selectUserOne(userInfo);
        aj.setTag(rs);
        //System.out.println(aj);
        return aj;
    }
    //注册
    @RequestMapping("/addUserRegister")
    @ResponseBody
    public AjaxResult addUserOne(UserInfo userInfo){
        AjaxResult aj=new AjaxResult();
        int rs=userService.addUserOne(userInfo);
        aj.setTag(rs);
        return aj;
    }
    //查登陆的用户
    @RequestMapping("/selectUserInfoById")
    @ResponseBody
    public  AjaxResult selectUserInfoById(UserInfo userInfo){
        AjaxResult aj=new AjaxResult();
       UserInfo rs=userService.selectUserInfoById(userInfo);
       if(rs!=null){
           aj.setTag(rs);
       }
        return aj;
    }
    //修改个人信息
    public AjaxResult updateUserInfoById(UserInfo userInfo){
        AjaxResult aj=new AjaxResult();
        int rs=userService.updateUserInfoById(userInfo);
        aj.setTag(rs);
        return aj;
    }
    //跳转个人中心
    @RequestMapping("/userPersonalInfo")
    public String gotoPersonalInfo(){
        return "user/personalInfo";
    }

    //加载个人信息界面
    @RequestMapping("/userInfo")
    public String gotoUserInfo(){
        return "user/userInfo";
    }
    //跳转个人积分页面
    @RequestMapping("/userIntegral")
    public String gotoIntegral(){
        return "user/integral";
    }
    //跳转个人图片
    @RequestMapping("/userGerenImg")
    public String gotoGerenImg(){
        return "user/gerenImg";
    }
    //加载个人积分

    //跳转个人账户页面
    @RequestMapping("/userAccount")
    public String userAccount(){
        return "user/account";
    }

    //加载个人积分

    //获得金额
    @RequestMapping("/getMoneyAccount")
    @ResponseBody
    public Object getMoneyAccount(HttpServletRequest request){
        return request.getSession().getAttribute("money");
    }

    //跳转订单页面
    @RequestMapping("/userGoOrder")
    public  String userOrder(){
        return  "user/myOrder";
    }
    //查看当前订单
    @RequestMapping("/userOrderLimit")
    @ResponseBody
    public DataTables userOrderLimit(HttpServletRequest request,int start,int length){
        Map<Object,Object> map=new HashMap<Object, Object>();
        System.out.println("---------------------------------"+request.getSession().getAttribute("frontuserId"));
        map.put("uId",request.getSession().getAttribute("frontuserId"));
        map.put("pageStart",start);
        map.put("pageSize",length);
        PageHelp<DoMyOrder> pageHelp=userService.selectOrderLimit(map);
        DataTables dataTables=new DataTables();
        dataTables.setData(pageHelp.getList());
        dataTables.setRecordsTotal(pageHelp.getRecord());
        dataTables.setRecordsFiltered(pageHelp.getRecord());
        return  dataTables;
    }
    //跳转历史订单
    @RequestMapping("/userGoSuccessOrder")
    public  String userOrderSuccess(){
        return  "user/myOrderSuccess";
    }
    @RequestMapping("/userSucOrderLimit")
    @ResponseBody
    public DataTables userSucOrderLimit(HttpServletRequest request,int start,int length){
        Map<Object,Object> map=new HashMap<Object, Object>();
        map.put("uId",request.getSession().getAttribute("frontuserId"));
        map.put("pageStart",start);
        map.put("pageSize",length);
        PageHelp<DoMyOrder> pageHelp=userService.selectMySuccessOrderLimit(map);
        DataTables dataTables=new DataTables();
        dataTables.setData(pageHelp.getList());
        dataTables.setRecordsTotal(pageHelp.getRecord());
        dataTables.setRecordsFiltered(pageHelp.getRecord());
        return  dataTables;
    }
    //请确认收货(和AdminOrderController同)
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
    //去付款
    @RequestMapping("/userOrderPayMoney")
    @ResponseBody
    public String userOrderPayMoney(HttpServletRequest request,String oId){
        DoPayMoney doPayMoney=new DoPayMoney();
        //获取登录用户
        UserInfo selectUserInfoMoney=userService.selectUserInfoMoney((Integer) request.getSession().getAttribute("frontuserId"));
        //获取购物车支付金额
        double selectOrderedMoney=sorderService.selectOrderedMoney(oId);
        doPayMoney.setuMoney(selectUserInfoMoney.getuMoney());
        doPayMoney.setPayMoney(String.valueOf(selectOrderedMoney));
        return ResponseUtil.successToClient(doPayMoney);
    }
    //确认付款
    @RequestMapping("/userOrderPayMoneyConfirm")
    @ResponseBody
    public String userOrderPayMoneyConfirm(HttpServletRequest request,Float payNumber,
                                           Float uMoney, String uPasword,String oId){
        UserInfo userInfo= (UserInfo) request.getSession().getAttribute("exitUser");
        if(userInfo.getuPassword().equals(uPasword)){//验证支付密码
            sorderService.updateOrderedByoId(oId);
            userService.updateUserInfoBypay(userInfo.getuId(),uMoney-payNumber);
        }else{
            return ResponseUtil.errorToClient();
        }
        return ResponseUtil.successToClient();

    }
    //删除订单
    @RequestMapping("/deleteMyOrder")
    public String deleteMyOrder(String oId){
        return ResponseUtil.successToClient(adminOrderService.deleteAdminOrder(oId));
    }
    //跳转管理员信息
    @RequestMapping("/mainToAdminuser")
    public String gooAdminUser(){
        return "admin/persionInfo/adminInfo";
    }
    //加载管理员信息
    @RequestMapping("/mainSelectAdminuser")
    @ResponseBody
    public String mainSelectAdminuser (HttpServletRequest request){
        int adId =(Integer) request.getSession().getAttribute("adminId");
        return ResponseUtil.successToClient(userService.selectAdminInfo(adId));
    }
    //更新管理员信息
    @RequestMapping("/mainUpdateAdminuser")
    @ResponseBody
    public String mainUpdateAdminuser(DoAdminInfo admin){
        return ResponseUtil.successToClient(userService.updateAdminInfo(admin));
    }


//    //主页
//    @RequestMapping("/index")
//    public String gotoIndex(){
//        return "user/index";
//    }
//
//    //登录页面
//    @RequestMapping("/userLogin")
//    public String gotoUserLogin(){
//        return "user/userLogin";
//    }
//
//    //退出登录页面
//
//    //商品详情页面
//    @RequestMapping("/proDetails")
//    public String gotoProDetails(){
//        return "product/proDetails";
//    }
//
//    //查询订单页面
//
//    //type页面
//    @RequestMapping("/typePage")
//    public String gotoUserTypePage(){
//        return "user/typePage";
//    }
}
