package com.arnoldatse.authmanager.admin.rest;

import com.arnoldatse.authmanager.admin.dto.ProfileResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class ProfileController {
    @GetMapping("/profile")
    public ProfileResponseDto profile(){
        return new ProfileResponseDto("user", "user@mail.com");
    }
}
