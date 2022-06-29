package com.example.fortylineshr.api;

import com.example.fortylineshr.dto.AuthInfoRequest;
import com.example.fortylineshr.dto.AuthInfoResponse;
import com.example.fortylineshr.service.impl.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping("/authenticate")
@RequiredArgsConstructor
public class AuthApi {

    private final AuthServiceImpl authService;

    @PostMapping
    @PermitAll
    public AuthInfoResponse authenticate(@RequestBody AuthInfoRequest authInfoRequest) {
        return authService.authenticate(authInfoRequest);
    }
}
