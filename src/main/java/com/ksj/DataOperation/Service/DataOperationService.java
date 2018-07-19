package com.ksj.DataOperation.Service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DataOperationService {
    /**
     *
     * 功能描述: 分页获取设备类型
     *
     * @param: 
     * @return: 
     */
    List<Map<String,Object>> getDeviceType(Integer page, Integer pageSize);
    
    /**
     *
     * 功能描述: 添加设备类型
     *
     * @param:
     * @return: 
     */
    Integer inserDeviceType(String TypeName,
                            String TypeDBName,
                            String TypeDescription,
                            String TypeTableName,
                            String DBIP);

    /**
     *
     * 功能描述: 查询设备类型总数
     *
     * @param:
     * @return: 
     */
    Integer getDeviceTypeCount();
    
    /**
     *
     * 功能描述:修改设备类型
     *
     * @param: 
     * @return: 
     */
    Integer updateDeviceTypeByID(String TypeId,
                                 String TypeName,
                                 String TypeDescription,
                                 String TypeDBName,
                                 String TypeTableName,
                                 String DBIP);
    
    /**
     *
     * 功能描述:删除设备类型
     *
     * @param: 
     * @return: 
     */
    Integer deleteDeviceTypeByID(String TypeId);
}
