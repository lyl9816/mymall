package com.snack.web;

import com.snack.pojo.domain.DoRecord;
import com.snack.service.AdminPieMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/map")
public class AdminPieMapController {
    @Autowired
    public AdminPieMapService adminPieMapService;

    //goto图形页面
    @RequestMapping("/mainToPieMap")
    public String gotoUserLogin(){
        return "/admin/table/pieMap";
    }

    //饼图
    @RequestMapping("/adminPieMapList")
    @ResponseBody
    public List<DoRecord> adminPieMapList(String startDate, String endDate,
                                          HttpServletRequest request){
//        String stratedate= (String) request.getSession().getAttribute("startDate");
//        System.out.println("strat---------------------:"+startDate);
        List<DoRecord> doRecordList=adminPieMapService.selectGroupBytype(startDate,endDate);
        System.out.println(doRecordList);
        return doRecordList;
    }
}
