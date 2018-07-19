package com.ksj.DataOperation.Mapper;


import com.ksj.Utils.WebTool;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface DeviceTableMapper {

    @Select("SHOW TABLES LIKE #{tableName}")
    List<Map<String, Object>> selectTable(@Param("tableName") String tableName);

    @UpdateProvider(type = DeviceTableProvider.class,
            method = "createTable")
    Integer createTable(String tableName, List<Object> rows);


    class DeviceTableProvider {

        public String createTable(String tableName, List<Object> rows) {
            boolean hasPKey = false;
            String sql = "CREATE TABLE IF NOT EXISTS `" + tableName + "` (";
            for (Object obj : rows) {
                if (obj instanceof Map) {
                    Map<String, Object> map = (HashMap<String, Object>) obj;
                    //字段名+字段类型
                    sql += "`" + map.get("FieldName") + "`" + " " + map.get("FieldType");

                    //字段长度
                    if (map.get("FieldLength") != null && map.get("FieldLength").toString().length() > 0) {
                        sql += "(";
                        sql += map.get("FieldLength");
                        //字段小数点
                        if (map.get("FieldPoint") != null && map.get("FieldPoint").toString().length() > 0) {
                            if (map.get("FieldType").equals("decimal")
                                    || map.get("FieldType").equals("float")
                                    || map.get("FieldType").equals("double"))
                                sql += "," + map.get("FieldPoint");
                            else {
                                WebTool.setMsg(map.get("FieldName") + "类型不为小数设置了小数点长度！");
                                return "SELECT SUM(0)";
                            }
                        }

                        sql += ")";
                    }
                    // 是否为主键
                    Boolean IsPKey = (Boolean) map.get("IsPKey");
                    if (IsPKey) {
                        if (hasPKey) {
                            WebTool.setMsg("有多个主键存在！");
                            return "SELECT SUM(0)";
                        }
                        sql += " PRIMARY KEY";
                        hasPKey = true;
                    }

                    //NOT NULL
                    Boolean notNull = (Boolean) map.get("NotNull");
                    if (notNull)
                        sql += " NOT NULL";

                    //自增 auto_increment
                    Boolean Increment = (Boolean) map.get("Increment");
                    if (Increment)
                        sql += " AUTO_INCREMENT";

                    //默认值
                    if (map.get("Default") != null && map.get("Default").toString().length() > 0)
                        sql += " DEFAULT '" + map.get("Default") + "'";

                    //注释
                    if (map.get("Comment") != null && map.get("Comment").toString().length() > 0)
                        sql += " COMMENT '" + map.get("Comment") + "'";
                    sql += ",";
                }
            }
            sql = sql.substring(0, sql.length() - 1);
            sql += ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
            System.out.println("****************************   " + sql);
            return sql;
        }

    }


}
