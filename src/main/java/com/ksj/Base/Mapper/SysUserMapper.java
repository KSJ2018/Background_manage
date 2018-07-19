package com.ksj.Base.Mapper;

import com.ksj.Base.Entity.SysResource;
import com.ksj.Base.Entity.SysRole;
import com.ksj.Base.Entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface SysUserMapper {

    @Select("SELECT * FROM s_user WHERE username = #{username}")
    SysUser findByUsername(@Param("username") String username);

    @Select("SELECT * FROM s_role WHERE id = (SELECT role_id FROM s_user_role WHERE user_id = #{userID})")
    List<SysRole> findRolesByUserId(@Param("userID")String id);

    @Select("SELECT * FROM s_resource WHERE id = (SELECT resource_id FROM s_role_resource WHERE role_id = #{roleID})")
    List<SysResource> findResourcesByRoleId(@Param("roleID")String id);

}
