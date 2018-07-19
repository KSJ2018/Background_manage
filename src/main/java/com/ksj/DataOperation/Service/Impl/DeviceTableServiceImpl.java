package com.ksj.DataOperation.Service.Impl;

import com.ksj.DataOperation.Mapper.DeviceTableMapper;
import com.ksj.DataOperation.Service.DeviceTableService;
import com.ksj.Utils.WebTool;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DeviceTableServiceImpl implements DeviceTableService {
    @Autowired
    DeviceTableMapper mapper;

    @Override
    public Integer createTable(String tableName, String rows) {
        //先查询表格是否存在
        Integer count = mapper.selectTable(tableName).size();
        if (count > 0){
            WebTool.setMsg("表格已存在!");
            return 0;
        }

        JSONArray array = null;
        try {
            array = new JSONArray(rows);
        }catch (Exception e){
            e.printStackTrace();
        }
        return mapper.createTable(tableName,array.toList());
    }
}
