package com.ksj.DataOperation.Controller;


import com.ksj.DataOperation.Service.Impl.SaleManagerServiceImpl;
import com.ksj.Utils.ResponseCode;
import com.ksj.Utils.WebTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
 @RequestMapping("/ksj")
 public class SaleManagerController {

 @Autowired
 SaleManagerServiceImpl saleManagerService;

 /**
  * 分页查询销售信息
  * @param request
  * @return
  */
 @RequestMapping("/getSaleInfo")
 @ResponseBody
     public Map<String,Object> getSaleInfo(HttpServletRequest request){
         Integer pageIndex=request.getParameter("page")==null
                 ||request.getParameter("page").equals("NaN")
                 ||request.getParameter("page").equals("undefined")?
                 1:Integer.valueOf(request.getParameter("page"));
         Integer pageSize=request.getParameter("rows")==null
                 ||request.getParameter("rows").equals("NaN")
                 ||request.getParameter("rows").equals("undefined")?
                 5:Integer.valueOf(request.getParameter("rows"));

         List<Map<String,Object>> result=saleManagerService.getSaleInfo(Integer.valueOf(pageIndex),Integer.valueOf(pageSize));

         Map<String,Object> returnMap=new HashMap<>();
         returnMap.put("rows",result);
         returnMap.put("total",saleManagerService.getSaleCount());
         return  returnMap;

     }

 /**
  * 添加新销售
  * @param request
  * @return
  */
     @RequestMapping("/insertSale")
     @ResponseBody
     public Map<String,Object> insertSale(HttpServletRequest request){
     Integer result=saleManagerService.insertSale(
             request.getParameter("client_id"),
             request.getParameter("equipment_name"),
             request.getParameter("equipment_price"),
             request.getParameter("description"),
             request.getParameter("note")
     );
     return WebTool.toResponseBody(result>0?ResponseCode.OK:ResponseCode.REASON,
             null,result > 0 ? "添加成功" : "添加失败");
     }

 /**
  * 修改销售信息
  * @param request
  *
  *
  * @return
  */
 @RequestMapping("/modifySaleById")
     @ResponseBody
     public  Map<String,Object> modifySaleById(HttpServletRequest request){
         Integer result=saleManagerService.modifySaleById(
                 request.getParameter("id"),
                 request.getParameter("client_id"),
                 request.getParameter("equipment_name"),
                 request.getParameter("equipment_price"),
                 request.getParameter("description"),
                 request.getParameter("note")
         );
         return  WebTool.toResponseBody(result > 0?ResponseCode.OK : ResponseCode.REASON,
                 null,result >0 ? "修改成功" : "修改失败");
     }

 /**
  * 删除销售信息
  * @param request
  * @return
  */
 @RequestMapping("/deleteSaleById")
     @ResponseBody
     public  Map<String,Object> deleteSaleById(HttpServletRequest request){
       Integer result=saleManagerService.deleteSaleById(
               request.getParameter("id")
       );
       return  WebTool.toResponseBody(result> 0?ResponseCode.OK :ResponseCode.REASON,
               null,result>0 ? "删除成功" : "删除失败");
     }


 }
