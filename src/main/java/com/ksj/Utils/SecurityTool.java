package com.ksj.Utils;



import com.ksj.Base.Entity.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import java.util.List;

public class SecurityTool {
    private static SecurityContext context = SecurityContextHolder.getContext();

    /** 当前登陆用户 **/
    private static SysUser currentUser;
    /** 当前登陆用户访问ip **/
    private static String currentIp;
    /** 当前登陆用户所有权限 **/
    private static List<GrantedAuthority> allAuth;


    public static List<GrantedAuthority> getAllAuth() {
        return allAuth;
    }

    public static void setAllAuth(List<GrantedAuthority> allAuth) {
        SecurityTool.allAuth = allAuth;
    }

    public static SysUser getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(SysUser currentUser) {
        SecurityTool.currentUser = currentUser;
    }

    public static String getCurrentIp() {
        return currentIp;
    }

    public static void setCurrentIp(String currentIp) {
        SecurityTool.currentIp = currentIp;
    }

}
