package com.arnoldatse.authmanager.admin.security;

import com.arnoldatse.authmanager.admin.dao.AdminRepository;
import com.arnoldatse.authmanager.admin.entities.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminUserDetailsService implements UserDetailsService {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUsernameOrEmail(login, login);
        System.out.println(
            "\n\n\n----------------------------------------------\n\n\n"
            +"admin: "+admin
            +"\n\n\n----------------------------------------------\n\n\n"
        );
        if(admin != null){
            return User.builder().username(login).password(admin.getPassword()).roles("ADMIN").build();
        }
        else{
            throw new UsernameNotFoundException("Admin not found");
        }
    }
}
