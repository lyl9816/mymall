package com.snack.service;

import com.snack.pojo.Account;
import com.snack.pojo.Admin;
import com.snack.pojo.UserInfo;
import com.snack.pojo.domain.DoAdminInfo;
import com.snack.pojo.domain.DoMyOrder;
import com.snack.utils.PageHelp;

import java.util.Map;

public interface UserService {
    //注册
    public UserInfo selectUserOne(UserInfo userinfo);
    //添加一名用户
    public int addUserOne(UserInfo userinfo);
    //根据id查用户
    public UserInfo selectUserInfoById(UserInfo userinfo);
    //根据id更新用户
    public int updateUserInfoById(UserInfo userinfo);
    //查询用户余额
    UserInfo selectUserInfoMoney(int uId);
    //更新用户余额
    int updateUserInfoBypay(int uId,float uMoney);
    //确认收货
    public int upDateByorderConfirm(int id,int typeNum,int eId);
    //查询历史订单
    public PageHelp<DoMyOrder> selectMySuccessOrderLimit(Map<Object,Object> map);
    //查询当前订单
    public PageHelp<DoMyOrder>  selectOrderLimit(Map<Object,Object> map);
    //选择用户操作（消费、提现、充值）
    public PageHelp<Account>  selectAccountLimit(Map<Object,Object> map);

    int updateAdminInfo(DoAdminInfo doadminInfo);

    Admin selectAdminInfo(int adId);
    //积分
//    public PageHelp<Integral> selectIntegralLimit(Map<Object,Object> map);

}
