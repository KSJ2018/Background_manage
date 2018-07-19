package com.ksj.ResourceManage.Service;

import java.util.List;
import java.util.Map;

public interface ResourceManageService {
    List<Map<String, Object>> getAllResources();
    List<Map<String, Object>> getTreeResources();
}
