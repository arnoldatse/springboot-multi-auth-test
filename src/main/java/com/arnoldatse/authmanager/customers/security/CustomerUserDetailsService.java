package com.arnoldatse.authmanager.customers.security;

import com.arnoldatse.authmanager.admin.dao.AdminRepository;
import com.arnoldatse.authmanager.admin.entities.Admin;
import com.arnoldatse.authmanager.customers.dao.CustomerRepository;
import com.arnoldatse.authmanager.customers.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByUsernameOrEmail(login, login);
        System.out.println(
                "\n\n\n----------------------------------------------\n\n\n"
                +"customer: "+customer
                +"\n\n\n----------------------------------------------\n\n\n"
        );


        if(customer != null){
            return User.builder().username(login).password(customer.getPassword()).roles("CUSTOMER").build();
        }
        else{
            throw new UsernameNotFoundException("Customer not found");
        }
    }
}
