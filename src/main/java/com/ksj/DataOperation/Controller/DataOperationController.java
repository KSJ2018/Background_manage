package com.ksj.DataOperation.Controller;

import com.ksj.DataOperation.Service.DataOperationService;
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
@RequestMapping("/DataOperation")
public class DataOperationController {

    @Autowired
    DataOperationService service;

    /**
     *
     * 功能描述: 分页获取设备类型
     *
     * @param:
     * @return:
     */
    @RequestMapping("/getDeviceType")
    @ResponseBody
    public Map<String, Object> getDeviceType(HttpServletRequest request) {
        Integer pageIndex = request.getParameter("page") == null
                || request.getParameter("page").equals("NaN")
                || request.getParameter("page").equals("undefined")?
                1 : Integer.valueOf(request.getParameter("page"));
        Integer pageSize = request.getParameter("rows") == null
                || request.getParameter("rows").equals("NaN")
                || request.getParameter("rows").equals("undefined")?
                5 : Integer.valueOf(request.getParameter("rows"));

        List<Map<String, Object>> result = service.getDeviceType(Integer.valueOf(pageIndex), Integer.valueOf(pageSize));

        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("rows", result);
        returnMap.put("total", service.getDeviceTypeCount());
        System.out.println(returnMap);
        return returnMap;
    }

    /**
     *
     * 功能描述: 添加设备类型
     *
     * @param:
     * @return:
     */
    @RequestMapping("/insertDeviceType")
    @ResponseBody
    public Map<String, Object> insertDeviceType(HttpServletRequest request) {
        Integer result = service.inserDeviceType(
                request.getParameter("TypeName"),
                request.getParameter("TypeDBName"),
                request.getParameter("TypeDescription"),
                request.getParameter("TypeTableName"),
                request.getParameter("DBIP"));
        return WebTool.toResponseBody(result > 0 ? ResponseCode.OK : ResponseCode.REASON,
                null,result > 0 ? "添加成功" : "添加失败");
    }

    /**
     *
     * 功能描述: 修改设备类型
     *
     * @param:
     * @return:
     */
    @RequestMapping("/updateDeviceType")
    @ResponseBody
    public Map<String, Object> updateDeviceType(HttpServletRequest request) {
        Integer result = service.updateDeviceTypeByID(
                request.getParameter("TypeId"),
                request.getParameter("TypeName"),
                request.getParameter("TypeDBName"),
                request.getParameter("TypeDescription"),
                request.getParameter("TypeTableName"),
                request.getParameter("DBIP"));
        return WebTool.toResponseBody(result > 0 ? ResponseCode.OK : ResponseCode.REASON,
                null,result > 0 ? "修改成功" : "修改失败");
    }

    /**
     *
     * 功能描述: 删除设备类型
     *
     * @param:
     * @return:
     */
    @RequestMapping("/deleteDeviceType")
    @ResponseBody
    public Map<String, Object> deleteDeviceType(HttpServletRequest request) {
        Integer result = service.deleteDeviceTypeByID(request.getParameter("TypeId"));
        return WebTool.toResponseBody(result > 0 ? ResponseCode.OK : ResponseCode.REASON,
                null,result > 0 ? "修改成功" : "修改失败");
    }

}
