package com.snack.service;

import com.snack.pojo.SnackInfo;
import com.snack.pojo.UserInfo;
import com.snack.pojo.domain.DoSnack;
import com.snack.utils.PageHelp;

import java.util.List;
import java.util.Map;

public interface ShopService {

    //查询热销商品
    List<SnackInfo> selectHotSnack();
    //查询最新商品
    List<SnackInfo> selectNewSnack();
    //用户登录
    public UserInfo userLogin(UserInfo userInfo);
    //根据id查商品
    public SnackInfo selectById(SnackInfo snackInfo);
    //查询下单商品
    PageHelp<DoSnack> selectOrderSnack(Map<Object,Object> map);
    //查询分类商品
    List<SnackInfo> selectPuffing(int type,String snackName);
}
