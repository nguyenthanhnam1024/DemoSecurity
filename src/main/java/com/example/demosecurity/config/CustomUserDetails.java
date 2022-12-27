package com.example.demosecurity.config;

import com.example.demosecurity.entity.AppRole;
import com.example.demosecurity.entity.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {

    private AppUser appUser;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<AppRole> roleNameList = this.appUser.getAppRoleList();

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
        if (roleNameList != null){
            for(AppRole appRole : roleNameList){
                GrantedAuthority authority = new SimpleGrantedAuthority(appRole.getRoleName());
                grantedAuthorityList.add(authority);
            }
        }
        return grantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
