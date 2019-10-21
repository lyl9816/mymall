package com.snack.service;

import com.snack.pojo.SnackInfo;
import com.snack.utils.PageHelp;

import java.util.Map;

public interface AdminSnackInfoService {

    //管理员查询商品限制
    PageHelp<SnackInfo> selectAdminSnackinfoLimit(Map<Object,Object> map);
    //管理员商品上架
    public int addAdminSnackinfo(SnackInfo snackInfo);
    //管理员商品删除
    public int delAdminSnackinfo(int sId);
    //根据id查找管理员用户
    public SnackInfo selectAdminUserinfoBysId(int sId);
    //管理员商品更新
    public int updateAdminSnackinfo(SnackInfo snackinfo);

}
