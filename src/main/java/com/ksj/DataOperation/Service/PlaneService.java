package com.ksj.DataOperation.Service;

import java.util.List;
import java.util.Map;

public interface PlaneService {

    List<Map<String, Object>> getPalne(Integer factoryId, Integer page, Integer pageSize);

    Integer getPlanesCount(Integer factoryId);

}
