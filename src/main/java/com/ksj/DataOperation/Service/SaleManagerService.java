package com.ksj.DataOperation.Service;

import java.util.List;
import java.util.Map;

public interface SaleManagerService {

    /**
     * 分页获取销售信息
     */
    List<Map<String,Object>> getSaleInfo(Integer page, Integer pageSize);

    /**
     * 新增销售信息
     */
    Integer insertSale(String client_id,
                       String equipment_name,
                       String equipment_price,
                       String description,
                       String note);

    /**
     * 修改销售信息
     */
    Integer modifySaleById(String id,
                           String client_id,
                           String equipment_name,
                           String equipment_price,
                           String description,
                           String note);

    /**
     * 删除信息
     */
    Integer deleteSaleById(String id);

    /**
     * 获取销售总数
     */
    Integer getSaleCount();
}
