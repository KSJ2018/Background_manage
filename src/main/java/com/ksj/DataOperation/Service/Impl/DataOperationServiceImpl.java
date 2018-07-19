package com.ksj.DataOperation.Service.Impl;

import com.ksj.DataOperation.Mapper.DataOperationMapper;
import com.ksj.DataOperation.Service.DataOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DataOperationServiceImpl implements DataOperationService {

    @Autowired
    DataOperationMapper mapper;

    @Override
    public List<Map<String, Object>> getDeviceType(Integer page, Integer pageSize) {
        return mapper.getDeviceType((page - 1) * pageSize,pageSize);
    }

    @Override
    public Integer inserDeviceType(String TypeName, String TypeDBName, String TypeDescription, String TypeTableName, String DBIP) {
        return mapper.inserDeviceType(TypeName,TypeDBName,TypeDescription,TypeTableName,DBIP);
    }

    @Override
    public Integer getDeviceTypeCount() {
        return mapper.getDeviceTypeCount();
    }

    @Override
    public Integer updateDeviceTypeByID(String TypeId, String TypeName, String TypeDescription, String TypeDBName, String TypeTableName, String DBIP) {
        return mapper.updateDeviceTypeByID(TypeId,TypeName,TypeDescription,TypeDBName,TypeTableName,DBIP);
    }

    @Override
    public Integer deleteDeviceTypeByID(String TypeId) {
        return mapper.deleteDeviceTypeByID(TypeId);
    }
}
