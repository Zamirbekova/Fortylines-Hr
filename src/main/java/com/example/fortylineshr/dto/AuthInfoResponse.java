package com.example.fortylineshr.dto;

import com.example.fortylineshr.enums.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthInfoResponse {
    private Role role;
    private String email;
    private String token;
    private String firstName;
    private String lastName;}
