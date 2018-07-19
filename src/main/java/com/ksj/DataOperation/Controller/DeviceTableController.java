package com.ksj.DataOperation.Controller;

import com.ksj.DataOperation.Service.DeviceTableService;
import com.ksj.Utils.ResponseCode;
import com.ksj.Utils.WebTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/DeviceTable")
public class DeviceTableController {
    @Autowired
    DeviceTableService service;
    /**
     * 功能描述: 删除设备类型
     *
     * @param:
     * @return:
     */
    @RequestMapping("/createDeviceTable")
    @ResponseBody
    public Map<String, Object> createDeviceTable(HttpServletRequest request) {

        Integer result = service.createTable(request.getParameter("tableName"),request.getParameter("rows"));
        return WebTool.toResponseBody(result > 0 ? ResponseCode.OK : ResponseCode.FAIL,
                null,null);
    }
}
