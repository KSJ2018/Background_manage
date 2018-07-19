package com.ksj.DataOperation.Controller;

import com.ksj.DataOperation.Service.PlaneService;
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
@RequestMapping("/Plane")
public class PlaneController {
    @Autowired
    PlaneService service;

    /**
     * 功能描述:分页获取工厂平面
     *
     * @param:
     * @return:
     */
    @RequestMapping("/getPlanes")
    @ResponseBody
    public Map<String, Object> getPlanes(HttpServletRequest request) {
        Integer pageIndex = request.getParameter("page") == null
                || request.getParameter("page").equals("NaN")
                || request.getParameter("page").equals("undefined") ?
                1 : Integer.valueOf(request.getParameter("page"));
        Integer pageSize = request.getParameter("rows") == null
                || request.getParameter("rows").equals("NaN")
                || request.getParameter("rows").equals("undefined") ?
                5 : Integer.valueOf(request.getParameter("rows"));
        Integer factoryId = Integer.valueOf(request.getParameter("id"));

        List<Map<String,Object>> result = service.getPalne(factoryId,pageIndex,pageSize);
        for (Map<String,Object> map : result){

        }
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("rows", result);
        returnMap.put("total", service.getPlanesCount(factoryId));
        System.out.println(returnMap);

        return returnMap;
    }
}
