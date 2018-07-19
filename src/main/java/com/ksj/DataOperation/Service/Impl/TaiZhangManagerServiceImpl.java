package com.ksj.DataOperation.Service.Impl;

import com.ksj.DataOperation.Mapper.TaiZhangManagerMapper;
import com.ksj.DataOperation.Service.TaiZhangManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TaiZhangManagerServiceImpl implements TaiZhangManagerService {
    @Autowired
    TaiZhangManagerMapper taiZhangManagerMapper;
    @Override
    public List<Map<String, Object>> getTaiZhangInfo(Integer page, Integer pageSize) {
        return taiZhangManagerMapper.getTaiZhangInfo((page-1)*pageSize,pageSize);
    }

    @Override
    public Integer insertTaiZhang(String equipment_user, String equipment_name, String equipment_type, String product_date, String control_type, String responsible, String protect_cycle,
                                  String equipment_vendor, String current_state,String comment) {
        return taiZhangManagerMapper.insertTaiZhang(equipment_user,equipment_name, equipment_type, product_date,control_type,responsible,protect_cycle,equipment_vendor,current_state,comment);
    }

    @Override
    public Integer getTaiZhangCount() {
        return taiZhangManagerMapper.getTaiZhangCount();
    }

    @Override
    public Integer modifyTaiZhangById(String id,String equipment_user, String equipment_name, String equipment_type, String product_date, String control_type, String responsible,
                                      String protect_cycle, String equipment_vendor, String current_state,String comment) {
        return taiZhangManagerMapper.modifyTaiZhangById(id,equipment_user,equipment_name,equipment_type,product_date,control_type,responsible,protect_cycle,equipment_vendor,current_state,comment);
    }

    @Override
    public Integer deletTaiZhangById(String id) {
        return taiZhangManagerMapper.deletTaiZhangById(id);
    }
}
