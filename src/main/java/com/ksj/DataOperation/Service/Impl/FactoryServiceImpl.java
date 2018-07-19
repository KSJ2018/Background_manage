package com.ksj.DataOperation.Service.Impl;

import com.ksj.DataOperation.Mapper.FactoryMapper;
import com.ksj.DataOperation.Service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class FactoryServiceImpl implements FactoryService {
    @Autowired
    FactoryMapper mapper;

    @Override
    public List<Map<String, Object>> getFactorys(Integer page, Integer pageSize) {
        return mapper.getFactory((page - 1) * pageSize, pageSize);
    }

    @Override
    public Integer getFactorysCount() {
        return mapper.getFactorysCount();
    }

    @Override
    public String getUserNameByFactoryId(String factoryId) {
        return mapper.getUserNameByFactoryId(factoryId);
    }

    @Override
    public List<Map<String, Object>> getAllUserName() {
        return mapper.getAllUserName();
    }

    @Override
    @Transactional(rollbackFor = {IllegalArgumentException.class})
    public boolean insertFactoryWithUser(String FactoryId, String FactoryName, String BeiZhu, String UserName) throws IllegalAccessException {
        Integer num1 = mapper.insertFactory(FactoryId, FactoryName, BeiZhu == null || BeiZhu.length() <= 0 ? "" : BeiZhu);
        Integer num2 = mapper.insertFactoryWithUser(UserName, FactoryId);
        if (num1 <= 0 || num2 <= 0) {
            throw new IllegalAccessException("添加失败！");
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = {IllegalArgumentException.class})
    public boolean updataFactoryWithUser(String id,String FactoryId, String FactoryName, String BeiZhu, String UserName) throws IllegalAccessException {
        Integer num1 = mapper.updateFactoryWithUser(Integer.valueOf(id),FactoryId,UserName);
        Integer num2 = mapper.updateFactory(Integer.valueOf(id),FactoryId,FactoryName, BeiZhu == null || BeiZhu.length() <= 0 ? "" : BeiZhu);
        if (num1 <= 0 || num2 <= 0) {
            throw new IllegalAccessException("修改失败！");
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = {IllegalArgumentException.class})
    public boolean deleteFactoryWithUser(String id, String FactoryId, String FactoryName, String BeiZhu, String UserName) throws IllegalAccessException {
        Integer num1 = mapper.deleteFactoryWithUser(FactoryId,UserName);
        Integer num2 = mapper.deleteFactory(Integer.valueOf(id));
        if (num1 <= 0 || num2 <= 0) {
            throw new IllegalAccessException("删除失败！");
        }
        return true;
    }


}
