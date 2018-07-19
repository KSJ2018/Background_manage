package com.ksj.ResourceManage.Service.Impl;

import com.ksj.ResourceManage.Mapper.ResourceManageMapper;
import com.ksj.ResourceManage.Service.ResourceManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ResourceManageServiceImpl implements ResourceManageService {
    @Autowired
    ResourceManageMapper mapper;

    @Override
    public List<Map<String, Object>> getAllResources() {
        List<Map<String, Object>> list = mapper.getAllResources();
        return list;
    }

    @Override
    public List<Map<String, Object>> getTreeResources() {
        List<Map<String, Object>> list = mapper.getAllResources();
        List<Map<String, Object>> result = new ArrayList<>();
        recursionToResult(list, null, result, true);
        sortToResult(result);
        return result;
    }

    /**
     * 排序
     **/
    public static void sortToResult(List<Map<String, Object>> result) {
        int i, j;

        for (i = 0; i < result.size() - 1; i++) {
            for (j = i + 1; j < result.size(); j++) {
                if (Integer.valueOf(result.get(i).get("index").toString()) > Integer.valueOf(result.get(j).get("index").toString())) {
                    Map temp = result.get(i);
                    result.set(i, result.get(j));
                    result.set(j, temp);
                }
            }
        }
        for (Map map : result) {
            if (map.get("submenu") != null && ((List) map.get("submenu")).size() > 0)
                sortToResult((List) map.get("submenu"));
        }


    }

    /**
     * 递归
     **/
    public static void recursionToResult(List<Map<String, Object>> data, List<Map<String, Object>> findPids, List<Map<String, Object>> result, boolean isFirst) {
        List<Map<String, Object>> find = new ArrayList<>();
        for (Map<String, Object> map : data) {
            if (isFirst) {
                map.put("submenu", new ArrayList<>());
                if (Integer.valueOf(map.get("parent_id").toString()) == 0) {
                    result.add(map);
                    find.add(map);
                }
            } else {
                for (Map<String, Object> map1 : findPids) {
                    if (Integer.valueOf(map.get("parent_id").toString()) == Integer.valueOf(map1.get("id").toString())) {
                        ((List) map1.get("submenu")).add(map);
                        find.add(map);
                    }
                }
            }
        }

        if (find.size() > 0)
            recursionToResult(data, find, result, false);

    }
}
