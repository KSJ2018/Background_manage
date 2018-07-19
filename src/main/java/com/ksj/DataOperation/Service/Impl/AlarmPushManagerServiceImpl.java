package com.ksj.DataOperation.Service.Impl;

import com.ksj.DataOperation.Mapper.AlarmPushManagerMapper;
import com.ksj.DataOperation.Service.AlarmPushManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AlarmPushManagerServiceImpl implements AlarmPushManagerService {
    @Autowired

    AlarmPushManagerMapper alarmPushManagerMapper;

    @Override
    public List<Map<String, Object>> getAlarmPushInfo(Integer page,Integer pageSize) {
        return alarmPushManagerMapper.getAlarmPushInfo((page-1)*pageSize,pageSize);
    }

    @Override



    public Integer getAlarmPushCount() {
        return alarmPushManagerMapper.getAlarmPushCount();
    }

    @Override
    public Integer insertAlarmPush(String point, String info, String type, String rank, String phone, String comment) {
        return alarmPushManagerMapper.insertAlarmPush(point,info,type,rank,phone,comment);
    }

    @Override
    public Integer modifyAlarmPushById(String id, String point, String info, String type, String rank, String phone, String comment) {
        return alarmPushManagerMapper.modifyAlarmPushById(id,point,info,type,rank,phone,comment);
    }

    @Override
    public Integer deleteAlarmPushById(String id) {
        return alarmPushManagerMapper.deleteAlarmPushById(id);
    }
}
