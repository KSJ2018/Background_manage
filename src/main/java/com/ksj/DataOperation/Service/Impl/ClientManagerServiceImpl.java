package com.ksj.DataOperation.Service.Impl;

import com.ksj.DataOperation.Mapper.ClientManagerMapper;
import com.ksj.DataOperation.Service.ClientManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClientManagerServiceImpl implements ClientManagerService {

    @Autowired
    ClientManagerMapper clientManagerMapper;

    @Override
    public List<Map<String, Object>> getClientInfo(Integer page, Integer pageSize) {
        return clientManagerMapper.getClientInfo((page - 1) * pageSize,pageSize);
    }

    @Override
    public Integer insertClient(String name, String phone, String salerecord,String address,String fax,String commment) {
        return clientManagerMapper.insertClient(name,phone,salerecord,address,fax,commment);
    }

    @Override
    public Integer modifyClientById(String id, String name, String phone, String salerecord,String address,String fax,String comment) {
        return clientManagerMapper.modifyClientById(id,name,phone,salerecord,address,fax,comment);
    }

    @Override
    public Integer deleteClientById(String id) {
        return clientManagerMapper.deleteClientById(id);
    }

    @Override
    public Integer getClientCount() {
        return clientManagerMapper.getClientCount();
    }

    @Override
    public List<Map<String, Object>> getClientInfoByName(Integer page, Integer pageSize,String inputName) {
        return null;
    }
}
