package com.ksj.Utils;


import java.util.HashMap;
import java.util.Map;

public class WebTool {

    private static String _msg;

    public static  Map<String,Object> toResponseBody(ResponseCode code,Object data,String msg){
        Map<String,Object> response = new HashMap<>();
        response.put("code",code.index);
        response.put("data",data);
        response.put("msg",msg == null ? _msg != null && _msg.length() > 0 ? _msg : "" : msg);
        _msg = "";
        return response;
    }

    public static void setMsg(String msg) {
        _msg = msg;
    }
}

