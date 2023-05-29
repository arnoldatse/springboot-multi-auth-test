package com.arnoldatse.authmanager.admin.dao;

import com.arnoldatse.authmanager.admin.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByUsername(String username);
    Admin findByEmail(String email);

    Admin findByUsernameOrEmail(String username, String email);
}
