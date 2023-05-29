package com.arnoldatse.authmanager.admin.dto;

public class ProfileResponseDto {
    private String username;
    private String email;

    public ProfileResponseDto(String username, String email){
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
