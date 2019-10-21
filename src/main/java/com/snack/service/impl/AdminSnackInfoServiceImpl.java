package com.snack.service.impl;

import com.snack.mapper.SnackInfoMapper;
import com.snack.pojo.SnackInfo;
import com.snack.service.AdminSnackInfoService;
import com.snack.utils.PageHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminSnackInfoServiceImpl implements AdminSnackInfoService {

    @Autowired
    private SnackInfoMapper snackInfoDao;

    //管理员查询商品限制
    public PageHelp<SnackInfo> selectAdminSnackinfoLimit(Map<Object, Object> map) {
        PageHelp<SnackInfo> pageHelp=new PageHelp<SnackInfo>();
        //查找商品集合及总数
        List<SnackInfo> selectAdminSnackLimit=snackInfoDao.selectAdminSnackLimit(map);
        int selectAdminSnackCount=snackInfoDao.selectAdminSnackCount(map);
        //并存入pageHelp
        pageHelp.setList(selectAdminSnackLimit);
        pageHelp.setRecord(selectAdminSnackCount);
        return pageHelp;
    }
    //管理员商品上架
    public int addAdminSnackinfo(SnackInfo snackInfo) {
        return snackInfoDao.insertSelective(snackInfo);
    }
    //管理员商品删除
    public int delAdminSnackinfo(int sId) {
        return snackInfoDao.deleteByPrimaryKey(sId);
    }
    //根据id查找管理员用户
    public SnackInfo selectAdminUserinfoBysId(int sId) {
        return snackInfoDao.selectByPrimaryKey(sId);
    }
    //管理员商品更新
    public int updateAdminSnackinfo(SnackInfo snackinfo) {
        return snackInfoDao.updateByPrimaryKeySelective(snackinfo);
    }
}
