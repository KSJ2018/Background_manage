package com.ksj.DataOperation.Service;


import java.util.List;
import java.util.Map;

public interface AlarmPushManagerService {

    /**
     * 分页查询报警推送信息
     */
    List<Map<String,Object>>  getAlarmPushInfo(Integer page, Integer pageSize);

    /**
     *查询报警推送总数目
     * @return
     */
    Integer getAlarmPushCount();

    /**
     *插入新的报警推送信息
     * @return
     */
    Integer insertAlarmPush(String point,
                            String info,
                            String type,
                            String rank,
                            String phone,
                            String comment);

    /**
     * 修改报警推送信息
     */
    Integer modifyAlarmPushById(String id,
                                String point,
                                String info,
                                String type,
                                String rank,
                                String phone,
                                String comment);

    /**
     * 删除报警推送信息
     */
    Integer deleteAlarmPushById(String id);

}
