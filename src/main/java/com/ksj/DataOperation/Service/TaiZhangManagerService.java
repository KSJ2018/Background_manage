package com.ksj.DataOperation.Service;

import java.util.List;
import java.util.Map;

public interface TaiZhangManagerService {

    /**
     *分页获取台账信息
     * @param pageSize
     * @return
     */
    List<Map<String,Object>> getTaiZhangInfo(Integer page, Integer pageSize);

    /**
     * 添加台账信息
     *
     * @return
     */
    Integer insertTaiZhang(String equipment_user,
                           String equipment_name,
                           String equipment_type,
                           String product_date,
                           String control_type,
                           String responsible,
                           String protect_cycle,
                           String equipment_vendor,
                           String current_state,
                           String comment
    );
    /**
     *查询总数
     */
    Integer getTaiZhangCount();

    /**
     *
     *修改台账
     * @return
     */
    Integer modifyTaiZhangById(String id,
                               String equipment_user,
                               String equipment_name,
                               String equipment_type,
                               String product_date,
                               String control_type,
                               String responsible,
                               String protect_cycle,
                               String equipment_vendor,
                               String current_state,
                               String comment);
    /**
     * 删除
     */
    Integer deletTaiZhangById(String id);


}
