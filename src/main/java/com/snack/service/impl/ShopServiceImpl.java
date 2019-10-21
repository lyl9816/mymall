package com.snack.service.impl;

import com.snack.mapper.SnackInfoMapper;
import com.snack.mapper.UserInfoMapper;
import com.snack.pojo.SnackInfo;
import com.snack.pojo.UserInfo;
import com.snack.pojo.domain.DoSnack;
import com.snack.service.ShopService;
import com.snack.utils.DateUtil;
import com.snack.utils.PageHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private SnackInfoMapper snackInfoDao;
    @Autowired
    private UserInfoMapper userInfoDao;


    //查询热销商品
    public List<SnackInfo> selectHotSnack() {
        Map<String,String> map=new HashMap<String, String>();
        Calendar calendar=Calendar.getInstance();//获取日历
        //获取当前月第一天和最后一天
        Date firstDayOfMonth= DateUtil.getFirstDayOfMonth(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH));
        Date lastDayOfMonth=DateUtil.getLastDayOfMonth(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH));
        //日期区间存入map
        map.put("firstday",DateUtil.getDateString(firstDayOfMonth));
        map.put("lastday",DateUtil.getDateString(lastDayOfMonth));
//        System.out.println("11111111111111111111111111111111111"+DateUtil.getDateString(firstDayOfMonth));
//        System.out.println("22222222222222222222222222222222222"+DateUtil.getDateString(lastDayOfMonth));
        List<SnackInfo> hotSnackList=snackInfoDao.selectHotSnack(map);
        return hotSnackList;
    }
    //查询最新商品
    public List<SnackInfo> selectNewSnack() {
        return snackInfoDao.selectNewSnack();
    }
    //用户登录
    public UserInfo userLogin(UserInfo userInfo) {
        return userInfoDao.selectUserLogin(userInfo);
    }
    //根据id查商品
    public SnackInfo selectById(SnackInfo snackInfo) {
        return snackInfoDao.selectByPrimaryKey(snackInfo.getsId());
    }

    //查询下单商品
    public PageHelp<DoSnack> selectOrderSnack(Map<Object, Object> map) {
        PageHelp<DoSnack> pageHelp=new PageHelp<DoSnack>();
        //selectOrderSnack的map存入pageHelp
        List<DoSnack> selectOrderSnackList=snackInfoDao.selectOrderSnack(map);
        pageHelp.setList(selectOrderSnackList);
        pageHelp.setRecord(selectOrderSnackList.size());
        return pageHelp;
    }
    //查询分类商品
    public List<SnackInfo> selectPuffing(int type,String snackName) {
        Map<String,String> map=new HashMap<String, String>();
        if(type==1){
            map.put("typeName", "膨化类");
        }else if(type==2){
            map.put("typeName", "肉制类");
        }else if(type==3){
            map.put("typeName", "饮料类");
        }else if(type==4){
            map.put("typeName", "其他");
        }else if(type==5){
            map.put("typeName", null);
        }else if(type==6){
            map.put("sImported", "1");
        }
        map.put("snackName",snackName);
        return snackInfoDao.selectPuffing(map);
    }
}
