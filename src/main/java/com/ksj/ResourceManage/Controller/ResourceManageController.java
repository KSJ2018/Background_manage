package com.ksj.ResourceManage.Controller;


import com.ksj.ResourceManage.Service.ResourceManageService;
import com.ksj.Utils.ResponseCode;
import com.ksj.Utils.SecurityTool;
import com.ksj.Utils.WebTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ResourceManage")
public class ResourceManageController {
    @Autowired
    ResourceManageService service;

    @RequestMapping("/getTreeResources")
    @ResponseBody
    public Map<String,Object> getTreeResources(){
        List<Map<String, Object>> result = service.getTreeResources();
        return WebTool.toResponseBody(ResponseCode.OK, result, null);
    }

    @RequestMapping("/getAllResources")
    @ResponseBody
    public Map<String,Object> getAllResources(){
        List<Map<String, Object>> result = service.getAllResources();
        return WebTool.toResponseBody(ResponseCode.OK, result, null);
    }

}
