package com.snack.web;

import com.snack.pojo.SnackInfo;
import com.snack.service.impl.AdminSnackInfoServiceImpl;
import com.snack.utils.DataTables;
import com.snack.utils.DateUtil;
import com.snack.utils.PageHelp;
import com.snack.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/snackinfo")
public class AdminSnackInfoController {
    @Autowired
    private AdminSnackInfoServiceImpl adminSnackInfoService;

    //上传图片
    @RequestMapping("/addAdminSnack")
    @ResponseBody
    public String upload(HttpServletRequest request, @RequestParam("file")MultipartFile file,
                         String fileName,SnackInfo snackInfo)throws Exception{
        //用日期设置id
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String sBatch=df.format(day).toString()+String.valueOf((int)(Math.random()*9000+1000));
        //设置商品属性
        snackInfo.setsCreatedate(DateUtil.getCurrentDate());
        snackInfo.setsBatch(sBatch);
        snackInfo.setState(1);
        snackInfo.setsPictureurl(fileName);
        adminSnackInfoService.addAdminSnackinfo(snackInfo);
        //若上传文件不为空
        if(!file.isEmpty()){
            //获取上传文件路径
            String path=request.getSession().getServletContext().getRealPath("/image/");
            String filename=fileName;
            File filepath=new File(path,filename);
            //若路径不存在，如果不存在就创建一个
            if(!filepath.exists()){
                filepath.getParentFile().mkdirs();
            }
            //保存以上文件,抛异常
            file.transferTo(new File(path+ File.separator + filename));
            return ResponseUtil.successToClient();//保存成功
        }
            return ResponseUtil.errorToClient();//保存失败
    }

    @RequestMapping("/mainToAdminSnackinfo")
    public String mainToAdminImg(){
        return "/admin/snackinfo/adminSnackinfo";
    }

    //管理员查询商品限制
    @RequestMapping("/adminSnackinfoLimit")
    @ResponseBody
    public DataTables adminOrderLimit(int start, int length, String sName, String sType,
                                      String startDate, String endDate){
        Map<Object,Object> map=new HashMap<Object, Object>();
        map.put("pageStart",start);
        map.put("pageSize",length);
        map.put("sName",sName);
        map.put("sType",sType);
        map.put("startDate",startDate);
        map.put("endDate",endDate);

        PageHelp<SnackInfo> pageHelp=adminSnackInfoService.selectAdminSnackinfoLimit(map);
        DataTables dataTables=new DataTables();
        dataTables.setData(pageHelp.getList());
        dataTables.setRecordsTotal(pageHelp.getRecord());
        dataTables.setRecordsFiltered(pageHelp.getRecord());
        return dataTables;


    }
    //管理员删除商品
    @RequestMapping("/delAdminUserinfo")
    @ResponseBody
    public String delSnackinfoById(int sId){
        return ResponseUtil.successToClient(adminSnackInfoService.delAdminSnackinfo(sId));
    }
    //加载商品
    @RequestMapping("/selectAdminUserinfoBysId")
    @ResponseBody
    public String selectAdminUserinfoBysId(int sId){
        return ResponseUtil.successToClient(adminSnackInfoService.selectAdminUserinfoBysId(sId));
    }
    //管理员更新商品
    @RequestMapping("/updateAdminSnack")
    @ResponseBody
    public String updateAdminSnack(HttpServletRequest request,MultipartFile file,
                                   String fileName,SnackInfo snackInfo)throws Exception{
        System.out.println("updateAdminSnack方法执行====================");
        //若文件不为空
        if(file!=null){
            snackInfo.setsPictureurl(fileName);
            adminSnackInfoService.updateAdminSnackinfo(snackInfo);
            //上传文件路径
            String path=request.getSession().getServletContext().getRealPath("/image/");
            //上传文件名
            String filename=fileName;
            File filepath=new File(path,filename);
            //若路径不存在，如果不存在就创建一个
            filepath.delete();//-----------------
            if(!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdirs();
            }
            // //保存以上文件,抛异常
            file.transferTo(new File(path+File.separator+filename));
            return ResponseUtil.successToClient();
        } else {
            adminSnackInfoService.updateAdminSnackinfo(snackInfo);
        return ResponseUtil.successToClient();
    }
    }

}
