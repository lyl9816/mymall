package com.snack.service.impl;

import com.snack.mapper.*;
import com.snack.pojo.*;
import com.snack.pojo.domain.DoAdminInfo;
import com.snack.pojo.domain.DoMyOrder;
import com.snack.service.UserService;
import com.snack.utils.DateUtil;
import com.snack.utils.PageHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.NameParser;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoDao;
    @Autowired
    private OrderMapper orderDao;
    @Autowired
    private SnackInfoMapper snackInfoDao;
    @Autowired
    private RecordMapper recordDao;
    @Autowired
    private AccountMapper accountDao;
    @Autowired
    private AdminMapper adminDao;

    //注册
    public UserInfo selectUserOne(UserInfo userinfo) {
        return userInfoDao.selectUserOne(userinfo);
    }
    //增加用户
    public int addUserOne(UserInfo userinfo) {
        userinfo.setuResgistdate(DateUtil.getCurrentDate());
        return userInfoDao.insert(userinfo);
    }
    //根据id查用户
    public UserInfo selectUserInfoById(UserInfo userinfo) {
        return userInfoDao.selectByPrimaryKey(userinfo.getuId());
    }

    //根据id更新用户
    public int updateUserInfoById(UserInfo userinfo) {
        return userInfoDao.updateByPrimaryKeySelective(userinfo);
    }

    //根据id查余额
    public UserInfo selectUserInfoMoney(int uId) {
        return userInfoDao.selectByPrimaryKey(uId);
    }

    //更新余额
    public int updateUserInfoBypay(int uId, float uMoney) {
        UserInfo u=new UserInfo();
        u.setuId(uId);
        u.setuMoney(String.valueOf(uMoney));
        return userInfoDao.updateByPrimaryKeySelective(u);
    }
    //确认收货
    public int upDateByorderConfirm(int id, int typeNum, int eId) {
        int updateByPrimaryKeySelective=-5;
        Order order=new Order();
        order.setId(id);
        order.setoType(typeNum);
        if(typeNum==0){
            //查询商品数量
            List<OrderDetail> selectAllSnackNum = selectAllSnackNum(id);
            //库存不够时
            for(OrderDetail orderDetail : selectAllSnackNum){
                SnackInfo snackInfo=snackInfoDao.selectByPrimaryKey(orderDetail.getsId());
                if(snackInfo.getsNumber()-orderDetail.getoNum()<0){
                    return  updateByPrimaryKeySelective;
                }
            }
            //库存数量够时
            for(OrderDetail orderDetail : selectAllSnackNum){
                SnackInfo snackInfo=snackInfoDao.selectByPrimaryKey(orderDetail.getsId());
                //设置订单属性
                Record record=new Record();
                record.setRecorddate(DateUtil.getCurrentDate());
                record.setRecordnumber(orderDetail.getoNum());
                record.setsId(orderDetail.getsId());
                //完成订单
                recordDao.insertSelective(record);
                //更新库存
                snackInfo.setsNumber(snackInfo.getsNumber()-orderDetail.getoNum());
                updateByPrimaryKeySelective=snackInfoDao.updateByPrimaryKeySelective(snackInfo);
            }
            order.seteId(eId);
        }
        orderDao.updateByPrimaryKeySelective(order);
        return updateByPrimaryKeySelective;
    }
    public List<OrderDetail> selectAllSnackNum(int id) {
        return orderDao.selectPushSnackNum(id);
    }
    //查询历史订单
    public PageHelp<DoMyOrder> selectMySuccessOrderLimit(Map<Object, Object> map) {
        PageHelp<DoMyOrder> pageHelp=new PageHelp<DoMyOrder>();
        //历史订单集合
        List<DoMyOrder> doMyOrderList=orderDao.selectMySuccessOrderLimit(map);
        OrderExample orderExample=new OrderExample();
        OrderExample.Criteria criteria=orderExample.createCriteria();
        criteria.andUIdEqualTo((Integer) map.get("uId"));
        criteria.andOTypeEqualTo(1);
        //订单数量
        int countByExample= (int) orderDao.countByExample(orderExample);
        pageHelp.setRecord(countByExample);
        pageHelp.setList(doMyOrderList);
        return pageHelp;
    }
    //查询当前订单
    public PageHelp<DoMyOrder> selectOrderLimit(Map<Object, Object> map) {
        PageHelp<DoMyOrder> pageHelp=new PageHelp<DoMyOrder>();
        //订单集合
        List<DoMyOrder> doMyOrderList=orderDao.selectMyOrderLimit(map);
        OrderExample orderExample=new OrderExample();
        OrderExample.Criteria criteria=orderExample.createCriteria();
        criteria.andUIdEqualTo((Integer) map.get("uId"));
        criteria.andOTypeEqualTo(1);
        //订单数量
        int countByExample= (int) orderDao.countByExample(orderExample);
        pageHelp.setList(doMyOrderList);
        pageHelp.setRecord(countByExample);
        return pageHelp;
    }
    //用户操作选项
    public PageHelp<Account> selectAccountLimit(Map<Object, Object> map) {
        PageHelp<Account> pageHelp=new PageHelp<Account>();
        List<Account> accountList=accountDao.selectAccountLimit(map);

        AccountExample accountExample=new AccountExample();
        AccountExample.Criteria criteria=accountExample.createCriteria();
        criteria.andUIdEqualTo((Integer) map.get("uId"));

        int countByExample= (int) accountDao.countByExample(accountExample);
        pageHelp.setRecord(countByExample);
        pageHelp.setList(accountList);
        return null;
    }

    public int updateAdminInfo(DoAdminInfo doadminInfo) {
        return adminDao.updateAdminInfo(doadminInfo);
    }

    public Admin selectAdminInfo(int adId) {
        return adminDao.selectByPrimaryKey(adId);
    }

}
