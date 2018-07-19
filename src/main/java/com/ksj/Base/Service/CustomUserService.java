package com.ksj.Base.Service;

import com.ksj.Base.Entity.SysResource;
import com.ksj.Base.Entity.SysRole;
import com.ksj.Base.Entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomUserService implements UserDetailsService {
    @Autowired
    SysUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser user = userRepository.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        List<SysRole> relos = userRepository.findRolesByUserId(user.getId().toString());
        if (relos != null && relos.size() > 0) {
            for (SysRole role : relos) {
                List<SysResource> resources = userRepository.findResourcesByRoleId(role.getId().toString());

                if (resources != null & resources.size() > 0)
                   role.setSysResources(resources);
            }
            user.setSysRoles(relos);
        }
        System.out.println(user);
        return user;
    }
}