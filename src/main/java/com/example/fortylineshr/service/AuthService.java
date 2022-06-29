package com.example.fortylineshr.service;

import com.example.fortylineshr.dto.AuthInfoRequest;
import com.example.fortylineshr.dto.AuthInfoResponse;

public interface AuthService {
    AuthInfoResponse authenticate(AuthInfoRequest authInfoRequest);

}
