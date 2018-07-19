package com.ksj.DataOperation.Controller;


import com.ksj.DataOperation.Service.Impl.AlarmPushManagerServiceImpl;
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
public class AlarmPushManagerController {

    @Autowired
    AlarmPushManagerServiceImpl alarmPushManagerService;

    /**
     * 分页查询报警推送信息
     * @param request
     * @return
     */
    @RequestMapping("/getAlarmPushInfo")
    @ResponseBody
    public Map<String,Object> getAlarmPushInfo(HttpServletRequest request){
        Integer pageIndex = request.getParameter("page") == null
                || request.getParameter("page").equals("NaN")
                || request.getParameter("page").equals("undefined")?
                1 : Integer.valueOf(request.getParameter("page"));
        Integer pageSize = request.getParameter("rows") == null
                || request.getParameter("rows").equals("NaN")
                || request.getParameter("rows").equals("undefined")?
                5 : Integer.valueOf(request.getParameter("rows"));

        List<Map<String,Object>> result=alarmPushManagerService.getAlarmPushInfo(Integer.valueOf(pageIndex),Integer.valueOf(pageSize));
        Map<String,Object> returnMap=new HashMap<>();
        returnMap.put("rows",result);
        returnMap.put("total",alarmPushManagerService.getAlarmPushCount());
        return  returnMap;

    }

    /**
     * 添加报警推送信息
     * @param request
     * @return
     */

    @RequestMapping("/insertAlarmPush")
    @ResponseBody
    public  Map<String,Object> insertAlarmPush(HttpServletRequest request){
        Integer result=alarmPushManagerService.insertAlarmPush(
                request.getParameter("point"),
                request.getParameter("info"),
                request.getParameter("type"),
                request.getParameter("rank"),
                request.getParameter("phone"),
                request.getParameter("comment")
        );
        return WebTool.toResponseBody(result>0?ResponseCode.OK:ResponseCode.REASON,
                null,result>0?"添加成功":"添加失败");
    }

    /**
     * 修改报警推送信息
     * @param request
     * @return
     */
    @RequestMapping("/modifyAlarmPushById")
    @ResponseBody
    public  Map<String,Object> modifyAlarmPushById(HttpServletRequest request){
        Integer result=alarmPushManagerService.modifyAlarmPushById(
                request.getParameter("id"),
                request.getParameter("point"),
                request.getParameter("info"),
                request.getParameter("type"),
                request.getParameter("rank"),
                request.getParameter("phone"),
                request.getParameter("comment")
        );
        return  WebTool.toResponseBody(result>0 ? ResponseCode.OK : ResponseCode.REASON,
                null,result>0 ? "修改成功" :"修改失败");
    }

    /**
     * 删除报警推送信息
     * @param request
     * @return
     */
    @RequestMapping("/deleteAlarmPushById")
    @ResponseBody
    public  Map<String,Object> deleteAlarmPushById(HttpServletRequest request){
        Integer result=alarmPushManagerService.deleteAlarmPushById(
            request.getParameter("id")
        );
        return  WebTool.toResponseBody(result>0?ResponseCode.OK:ResponseCode.REASON,
        null,result>0?"删除成功":"删除失败");
    }
}
