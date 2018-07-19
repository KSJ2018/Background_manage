package com.ksj.DataOperation.Controller;

import com.ksj.DataOperation.Service.FactoryService;
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
@RequestMapping("/Factory")
public class FactoryController {
    @Autowired
    FactoryService service;

    /**
     * 功能描述:分页获取工厂
     *
     * @param:
     * @return:
     */
    @RequestMapping("/getFactorys")
    @ResponseBody
    public Map<String, Object> getFactorys(HttpServletRequest request) {
        Integer pageIndex = request.getParameter("page") == null
                || request.getParameter("page").equals("NaN")
                || request.getParameter("page").equals("undefined") ?
                1 : Integer.valueOf(request.getParameter("page"));
        Integer pageSize = request.getParameter("rows") == null
                || request.getParameter("rows").equals("NaN")
                || request.getParameter("rows").equals("undefined") ?
                5 : Integer.valueOf(request.getParameter("rows"));

        List<Map<String, Object>> result = service.getFactorys(Integer.valueOf(pageIndex), Integer.valueOf(pageSize));

        //遍历查询工厂所对应的用户插入到返回结果挡住
        for (Map<String, Object> factory : result) {
            String userName = service.getUserNameByFactoryId(factory.get("FactoryId").toString());
            factory.put("UserName", userName);
        }

        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("rows", result);
        returnMap.put("total", service.getFactorysCount());
        System.out.println(returnMap);
        return returnMap;
    }

    /**
     * 功能描述:获取所有用户名
     *
     * @param:
     * @return:
     */
    @RequestMapping("/getAllUserName")
    @ResponseBody
    public Map<String, Object> getAllUserName(HttpServletRequest request) {
        return WebTool.toResponseBody(ResponseCode.OK, service.getAllUserName(), null);
    }

    /**
     * 功能描述:添加工厂
     *
     * @param:
     * @return:
     */
    @RequestMapping("/insertFactory")
    @ResponseBody
    public Map<String, Object> insertFactory(HttpServletRequest request) {
        String FactoryId = request.getParameter("FactoryId");
        String FactoryName = request.getParameter("FactoryName");
        String BeiZhu = request.getParameter("BeiZhu");
        String UserName = request.getParameter("UserName");

        //添加工厂
        boolean insertFacWithUser = false;
        try {
            insertFacWithUser = service.insertFactoryWithUser(FactoryId, FactoryName, BeiZhu, UserName);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return WebTool.toResponseBody(insertFacWithUser ? ResponseCode.OK : ResponseCode.FAIL, null, null);
    }
    
    /**
     *
     * 功能描述:修改工厂
     *
     * @param:
     * @return:
     */
    @RequestMapping("/updateFactory")
    @ResponseBody
    public Map<String, Object> updateFactory(HttpServletRequest request) {
        String id = request.getParameter("id");
        String FactoryId = request.getParameter("FactoryId");
        String FactoryName = request.getParameter("FactoryName");
        String BeiZhu = request.getParameter("BeiZhu");
        String UserName = request.getParameter("UserName");

        //修改工厂
        boolean result = false;
        try {
            result = service.updataFactoryWithUser(id,FactoryId,FactoryName,BeiZhu,UserName);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        return WebTool.toResponseBody(result ? ResponseCode.OK : ResponseCode.FAIL, null, null);
    }

    /**
     *
     * 功能描述:删除工厂
     *
     * @param:
     * @return:
     */
    @RequestMapping("/deleteFactory")
    @ResponseBody
    public Map<String, Object> deleteFactory(HttpServletRequest request) {
        String id = request.getParameter("id");
        String FactoryId = request.getParameter("FactoryId");
        String FactoryName = request.getParameter("FactoryName");
        String BeiZhu = request.getParameter("BeiZhu");
        String UserName = request.getParameter("UserName");
        boolean result = false;
        try {
            result = service.deleteFactoryWithUser(id,FactoryId,FactoryName,BeiZhu,UserName);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return WebTool.toResponseBody(result ? ResponseCode.OK : ResponseCode.FAIL, null, null);
    }


}
