package com.ksj.Base.Service;

import com.ksj.Base.Entity.SysResource;
import com.ksj.Base.Entity.SysRole;
import com.ksj.Base.Entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByUsername(String username);

    List<SysRole> findRolesByUserId(String id);

    List<SysResource> findResourcesByRoleId(String id);
}
