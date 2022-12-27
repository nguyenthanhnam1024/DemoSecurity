package com.example.demosecurity.service;

import com.example.demosecurity.config.CustomUserDetails;
import com.example.demosecurity.entity.AppRole;
import com.example.demosecurity.entity.AppUser;
import com.example.demosecurity.repository.AppRoleRepository;
import com.example.demosecurity.repository.AppUserRepository;
import com.example.demosecurity.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceIlm implements UserDetailsService {

    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    AppRoleRepository appRoleRepository;
    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser appUser = appUserRepository.findAppUserByUserName(username);
        if(appUser == null){
            throw new UsernameNotFoundException("app user khong ton tai");
        }
        return new CustomUserDetails(appUser);
    }
}
