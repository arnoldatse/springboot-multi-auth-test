package com.arnoldatse.authmanager.customers.dao;

import com.arnoldatse.authmanager.admin.entities.Admin;
import com.arnoldatse.authmanager.customers.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.config.Customizer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByUsername(String username);
    Customer findByEmail(String email);

    Customer findByUsernameOrEmail(String username, String email);
}
