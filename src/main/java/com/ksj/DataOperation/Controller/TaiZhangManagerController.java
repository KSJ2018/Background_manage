package com.ksj.DataOperation.Controller;

import com.ksj.DataOperation.Service.Impl.TaiZhangManagerServiceImpl;
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
public class TaiZhangManagerController {
@Autowired
TaiZhangManagerServiceImpl taiZhangManagerService;

    /**
     * 分页获取台账信息
     * @param request
     * @return
     */
    @RequestMapping("/getTaiZhangInfo")
    @ResponseBody
public Map<String,Object> getTaiZhangInfo(HttpServletRequest request){
    Integer pageIndex = request.getParameter("page") == null
            || request.getParameter("page").equals("NaN")
            || request.getParameter("page").equals("undefined")?
            1 : Integer.valueOf(request.getParameter("page"));
    Integer pageSize = request.getParameter("rows") == null
            || request.getParameter("rows").equals("NaN")
            || request.getParameter("rows").equals("undefined")?
            5 : Integer.valueOf(request.getParameter("rows"));

    List<Map<String,Object>> result=taiZhangManagerService.getTaiZhangInfo(Integer.valueOf(pageIndex),Integer.valueOf(pageSize));

    Map<String,Object> returnMap=new HashMap<>();
    returnMap.put("rows",result);
    returnMap.put("total",taiZhangManagerService.getTaiZhangCount());
    return  returnMap;

}

    /**
     * 添加台账信息
     * @param request
     * @return
     */
    @RequestMapping("/insertTaiZhang")
    @ResponseBody
public  Map<String,Object> insertTaiZhang(HttpServletRequest request){
    Integer result=taiZhangManagerService.insertTaiZhang(
            request.getParameter("equipment_user"),
            request.getParameter("equipment_name"),
            request.getParameter("equipment_type"),
            request.getParameter("product_date"),
            request.getParameter("control_type"),
            request.getParameter("responsible"),
            request.getParameter("protect_cycle"),
            request.getParameter("equipment_vendor"),
            request.getParameter("current_state"),
            request.getParameter("comment")

    );
    return WebTool.toResponseBody(result>0?ResponseCode.OK:ResponseCode.REASON,
            null,result>0 ? "添加成功"  : "添加失败");

}

    /**
     * 修改台账
     * @param request
     *
     *
     * @return
     */
 @RequestMapping("/modifyTaiZhangById")
 @ResponseBody
public Map<String,Object> modifyTaiZhangById(HttpServletRequest request){
    Integer result=taiZhangManagerService.modifyTaiZhangById(
            request.getParameter("id"),
            request.getParameter("equipment_user"),
            request.getParameter("equipment_name"),
            request.getParameter("equipment_type"),
            request.getParameter("product_date"),
            request.getParameter("control_type"),
            request.getParameter("responsible"),
            request.getParameter("protect_cycle"),
            request.getParameter("equipment_vendor"),
            request.getParameter("current_state"),
            request.getParameter("comment")
    );
    return WebTool.toResponseBody(result>0?ResponseCode.OK:ResponseCode.REASON,
            null,result>0 ? "修改成功"  : "修改失败");

}

    /**
     * 删除
     * @param request
     * @return
     */
@RequestMapping("/deletTaiZhangById")
@ResponseBody
public Map<String,Object> deletTaiZhangById(HttpServletRequest request){
     Integer result=taiZhangManagerService.deletTaiZhangById(
            request.getParameter("id"));
     return WebTool.toResponseBody(result>0?ResponseCode.OK : ResponseCode.REASON,
             null,result>0? "删除成功":"删除失败");


}
}
