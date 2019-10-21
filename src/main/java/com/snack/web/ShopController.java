package com.snack.web;

import com.snack.pojo.SnackInfo;
import com.snack.pojo.UserInfo;
import com.snack.pojo.domain.DoSnack;
import com.snack.pojo.domain.DoSnackType;
import com.snack.service.impl.ShopServiceImpl;

import com.snack.utils.DataTables;
import com.snack.utils.PageHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopServiceImpl shopService;
    //主页
    @RequestMapping("/index")
    public String gotoIndex(HttpServletRequest request){
        List<SnackInfo> HotSnackList=shopService.selectHotSnack();
        List<SnackInfo> newSnackList=shopService.selectNewSnack();
        request.setAttribute("HotSnackList",HotSnackList);
        request.setAttribute("newSnackList",newSnackList);
        return "user/index";
    }
    //登录
    @RequestMapping("/userLoginGet")
    public String gotoUserLogin(){
        System.out.println("------------------------------userLoginGet-----------------");
        return "user/userLogin";
    }
    @RequestMapping("/userLoginPost")
    public String gotoUserLogin(UserInfo userInfo,HttpServletRequest request){
        UserInfo exitUser=shopService.userLogin(userInfo);
        if(exitUser==null){
            request.setAttribute("msg","用户名或密码错误");
            return "user/userLogin";
        }
        request.getSession().setAttribute("exitUser",exitUser);
        request.getSession().setAttribute("frontuser",exitUser.getuUsername());
        request.getSession().setAttribute("frontuserId", exitUser.getuId());
        request.getSession().setAttribute("money", exitUser.getuMoney());
        System.out.println("--------------------userLoginPost----------------------");
        return "redirect:index";
    }

    //退出登录
    @RequestMapping("/userlogout")
    public String userLogout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("frontuser");
        session.removeAttribute("frontuserId");
        System.out.println("--------------userLogout-----------------");
        return  "redirect:userLoginGet";
    }
    //商品详情
    @RequestMapping("/proDetail")
    public String gotoProDetail(HttpServletRequest request,SnackInfo snackInfo){
        System.out.println("--------------gotoProDetail-----------------");
        SnackInfo sck=shopService.selectById(snackInfo);
        request.getSession().setAttribute("sck",sck);//传入前端sck
        return  "product/proDetail";
    }
    //查询订单
    @RequestMapping("/selectOrderSnack")
    @ResponseBody
    public DataTables selectOrderSnack(String oId, int start, int length){
        Map<Object,Object> map=new HashMap<Object, Object>();
        map.put("oId",oId);
        map.put("pageStart",start);
        map.put("pageSize",length);
        PageHelp<DoSnack> pageHelp=shopService.selectOrderSnack(map);
        DataTables tables=new DataTables();
        tables.setRecordsTotal(pageHelp.getRecord());
        tables.setRecordsFiltered(pageHelp.getRecord());
        tables.setData(pageHelp.getList());
        return  tables;

    }
    //type页面
    @RequestMapping("/puffingType")
    public String puffingType(HttpServletRequest request, DoSnackType doSnackType){
        List<SnackInfo> TypeSnackList=shopService.selectPuffing(doSnackType.getType(),doSnackType.getSnackName());
        if(doSnackType.getType()==1){
            request.setAttribute("TypeSnackTitle","膨化类");
        }else if(doSnackType.getType()==2){
            request.setAttribute("TypeSnackTitle","肉制类");
        }else if(doSnackType.getType()==3){
            request.setAttribute("TypeSnackTitle","饮料类");
        }else if(doSnackType.getType()==4){
            request.setAttribute("TypeSnackTitle","其他");
        }else if(doSnackType.getType()==5){
            request.setAttribute("TypeSnackTitle","搜索结果");
        }else if(doSnackType.getType()==6){
            request.setAttribute("TypeSnackTitle","进口类");
        }
        request.setAttribute("TypeNum",doSnackType.getType());
        request.setAttribute("TypeSnackList",TypeSnackList);
        return "user/typePage";
    }
}
