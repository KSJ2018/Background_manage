package com.ksj.DataOperation.Service;

import java.util.List;
import java.util.Map;

public interface ClientManagerService {
    /**
     * 分页获取客户信息
     */
    List<Map<String,Object>> getClientInfo(Integer page, Integer pageSize);

    /**
     * 新增客户信息
     */
    Integer insertClient(String name,
                         String phone,
                         String salerecord,
                         String address,
                         String fax,
                         String comment);

    /**
     * 修改客户信息
     */
    Integer modifyClientById(String id,
                             String name,
                             String phone,
                             String salerecord,
                             String address,
                             String fax,
                             String comment);

    /**
     * 删除信息
     */
    Integer deleteClientById(String id);

    /**
     * 获取客户总数
     */
    Integer getClientCount();

    /**
     * 根据姓名查找客户信息
     */
    List<Map<String,Object>> getClientInfoByName(Integer page, Integer pageSize, String inputName);
}
