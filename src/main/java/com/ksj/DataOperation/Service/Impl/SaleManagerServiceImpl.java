package com.ksj.DataOperation.Service.Impl;

import com.ksj.DataOperation.Mapper.SaleManagerMapper;
import com.ksj.DataOperation.Service.SaleManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SaleManagerServiceImpl implements SaleManagerService {
    @Autowired
    SaleManagerMapper saleManagerMapper;

    @Override
    public List<Map<String, Object>> getSaleInfo(Integer page, Integer pageSize) {
        return saleManagerMapper.getSaleInfo((page-1)*pageSize,pageSize);
    }

    @Override
    public Integer insertSale(String client_id, String equipment_name, String equipment_price, String description,String note) {
        return saleManagerMapper.insertSale(client_id,equipment_name,equipment_price,description,note);
    }

    @Override
    public Integer modifySaleById(String id, String client_id, String equipment_name, String equipment_price, String description,String note) {
        return saleManagerMapper.modifySaleById(id,client_id,equipment_name,equipment_price,description,note);
    }

    @Override
    public Integer deleteSaleById(String id) {
        return saleManagerMapper.deleteSaleById(id);
    }

    @Override
    public Integer getSaleCount() {
        return saleManagerMapper.getSaleCount();
    }
}
