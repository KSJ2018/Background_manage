package com.ksj.DataOperation.Service.Impl;

import com.ksj.DataOperation.Mapper.PlaneMapper;
import com.ksj.DataOperation.Service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PlaneServiceImpl implements PlaneService {
    @Autowired
    PlaneMapper mapper;

    @Override
    public List<Map<String, Object>> getPalne(Integer factoryId, Integer page, Integer pageSize) {
        return mapper.getPalne(factoryId,(page - 1) * pageSize, pageSize);
    }

    @Override
    public Integer getPlanesCount(Integer factoryId) {
        return mapper.getPlanesCount(factoryId);
    }
}
