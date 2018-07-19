package com.ksj.FileUpload.Service;

import java.util.List;
import java.util.Map;

public interface FileUploadService {

    /**
     *
     * 功能描述:获取当前用户下面的工厂
     *
     * @param: 
     * @return: 
     */
    List<Map<String,Object>> getFactorysById(Integer id);

}
