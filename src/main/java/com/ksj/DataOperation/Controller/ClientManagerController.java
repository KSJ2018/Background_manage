package com.ksj.DataOperation.Controller;

import com.ksj.DataOperation.Service.Impl.ClientManagerServiceImpl;
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
public class ClientManagerController {
@Autowired
ClientManagerServiceImpl clientManagerService;

/**
 * 分页查询客户信息
 * @param request
 * @return
 */
@RequestMapping("/getClientInfo")
@ResponseBody
    public Map<String,Object> getClientInfo(HttpServletRequest request){
        Integer pageIndex = request.getParameter("page") == null
                || request.getParameter("page").equals("NaN")
                || request.getParameter("page").equals("undefined")?
                1 : Integer.valueOf(request.getParameter("page"));
        Integer pageSize = request.getParameter("rows") == null
                || request.getParameter("rows").equals("NaN")
                || request.getParameter("rows").equals("undefined")?
                5 : Integer.valueOf(request.getParameter("rows"));

        List<Map<String,Object>> result=clientManagerService.getClientInfo(Integer.valueOf(pageIndex),Integer.valueOf(pageSize));

        Map<String,Object> returnMap=new HashMap<>();
        returnMap.put("rows",result);
        returnMap.put("total",clientManagerService.getClientCount());
        return returnMap;
    }

/**
 * 添加新客户
 * @param request
 * @return
 */
@RequestMapping("/insertClient")
    @ResponseBody
    public Map<String,Object> insertClient(HttpServletRequest request){
    Integer result=clientManagerService.insertClient(
            request.getParameter("name"),
            request.getParameter("phone"),
            request.getParameter("salerecord"),
            request.getParameter("address"),
            request.getParameter("fax"),
            request.getParameter("comment")
    );
    return WebTool.toResponseBody(result>0?ResponseCode.OK:ResponseCode.REASON,
            null,result > 0 ? "添加成功" : "添加失败");
    }

/**
 * 修改客户信息
 * @param request
 * @return
 */
@RequestMapping("/modifyClientById")
@ResponseBody
    public  Map<String,Object> modifyClientById(HttpServletRequest request){
    Integer result=clientManagerService.modifyClientById(
            request.getParameter("id"),
            request.getParameter("name"),
            request.getParameter("phone"),
            request.getParameter("salerecord"),
            request.getParameter("address"),
            request.getParameter("fax"),
            request.getParameter("comment")
    );
    return WebTool.toResponseBody(result >0 ?ResponseCode.OK : ResponseCode.REASON,
            null,result > 0 ? "修改成功" : "修改失败");
    }

/**
 * 删除客户
 * @param request
 * @return
 */
@RequestMapping("/deleteClientById")
    @ResponseBody
    public Map<String,Object> deleteClientById(HttpServletRequest request){
    Integer result=clientManagerService.deleteClientById(request.getParameter("id"));
    return WebTool.toResponseBody(result > 0 ? ResponseCode.OK : ResponseCode.REASON,
            null,result > 0 ? "删除成功" : "删除失败");
    }

    /**
     * 根据姓名查找客户
     * @param request
     * @return
     */
    @RequestMapping("/getClientInfoByName")
    @ResponseBody
    public  Map<String ,Object> getClientInfoByName(HttpServletRequest request){
        Integer pageIndex = request.getParameter("page") == null
                || request.getParameter("page").equals("NaN")
                || request.getParameter("page").equals("undefined")?
                1 : Integer.valueOf(request.getParameter("page"));
        Integer pageSize = request.getParameter("rows") == null
                || request.getParameter("rows").equals("NaN")
                || request.getParameter("rows").equals("undefined")?
                5 : Integer.valueOf(request.getParameter("rows"));
        List<Map<String,Object>> result=clientManagerService.getClientInfoByName(Integer.valueOf(pageIndex),Integer.valueOf(pageSize),
                request.getParameter("inputName"));
        Map<String,Object> returnMap=new HashMap<>();
        returnMap.put("rows",result);
        returnMap.put("total",clientManagerService.getClientCount2(request.getParameter("inputName")));
        return returnMap;
    }
}
