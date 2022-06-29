package com.example.fortylineshr.service.impl;

import com.example.fortylineshr.dto.AuthInfoRequest;
import com.example.fortylineshr.dto.AuthInfoResponse;
import com.example.fortylineshr.exceptionl.NotFoundException;
import com.example.fortylineshr.jwtconfig.JwtUtils;
import com.example.fortylineshr.model.Admin;
import com.example.fortylineshr.model.AuthInfo;
import com.example.fortylineshr.model.Employee;
import com.example.fortylineshr.model.HeadOf;
import com.example.fortylineshr.repository.AdminRepository;
import com.example.fortylineshr.repository.AuthRepository;
import com.example.fortylineshr.repository.EmployeeRepository;
import com.example.fortylineshr.repository.HeadOfRepository;
import com.example.fortylineshr.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final AuthRepository authInfoRepository;
    private final AdminRepository userRepository;
    private final HeadOfRepository headOfRepository;
    private final EmployeeRepository employeeRepository;
@Override
    public AuthInfoResponse authenticate(AuthInfoRequest authInfoRequest) {
        Authentication authentication;

        authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authInfoRequest.getEmail(),
                authInfoRequest.getPassword()
        ));

        String generatedToken = jwtUtils.generateToken(authentication);

        AuthInfo authInfo = authInfoRepository.findByEmail(authInfoRequest.getEmail())
                .orElseThrow(() -> {
                    log.error("User with email = {} does not exist", authInfoRequest.getEmail());
                    throw new NotFoundException(
                            String.format("User with email = %s does not exist", authInfoRequest.getEmail())
                    );
                });

        String firstName = "";
        String lastName = "";
        for (Admin u : userRepository.findAll()) {
            if (u.getAuthInfo().getEmail().equals(authInfo.getEmail())) {
                firstName = u.getFirstName();
                lastName = u.getLastName();
            }
            for (HeadOf h : headOfRepository.findAll()) {
                if (h.getAuthInfo().getEmail().equals(authInfo.getEmail())) {
                    firstName = h.getFirstName();
                    lastName = h.getLastName();
                }
            }
            for (Employee e : employeeRepository.findAll()) {
                if (e.getAuthInfo().getEmail().equals(authInfo.getEmail())) {
                    firstName = e.getFirstName();
                    lastName = e.getLastName();
                }
            }
        }

        return AuthInfoResponse.builder()
                .firstName(firstName)
                .lastName(lastName)
                .role(authInfo.getRole())
                .email(authInfoRequest.getEmail())
                .token(generatedToken)
                .build();
    }
}

