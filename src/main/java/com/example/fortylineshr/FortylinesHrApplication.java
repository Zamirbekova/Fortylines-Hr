package com.example.fortylineshr;

import com.example.fortylineshr.enums.Role;
import com.example.fortylineshr.model.Admin;
import com.example.fortylineshr.model.AuthInfo;
import com.example.fortylineshr.model.Employee;
import com.example.fortylineshr.model.HeadOf;
import com.example.fortylineshr.repository.AdminRepository;
import com.example.fortylineshr.repository.EmployeeRepository;
import com.example.fortylineshr.repository.HeadOfRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@SpringBootApplication
@RequiredArgsConstructor
public class FortylinesHrApplication {

    private final AdminRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final HeadOfRepository headOfRepository;
    private final EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(FortylinesHrApplication.class, args);
    }

    @GetMapping("/")
    public String greetingPage() {
        return "<h1>Welcome to Fortylines-Io application !!!<h1/>";
    }

    @PostConstruct
    public void init() {
        Admin user = new Admin();
        user.setFirstName("Admin");
        user.setLastName("Adminov");

        AuthInfo authInfo1 = new AuthInfo();
        authInfo1.setId(3L);
        authInfo1.setEmail("admin@gmail.com");
        authInfo1.setPassword(passwordEncoder.encode("admin"));
        authInfo1.setRole(Role.ADMIN);
        user.setAuthInfo(authInfo1);
        repository.save(user);

    }

    @PostConstruct
    public void init2() {
        HeadOf headOf = new HeadOf();
        headOf.setFirstName("head");
        headOf.setLastName("head");
headOf.setId(1L);
        AuthInfo authInfo = new AuthInfo();
        authInfo.setId(1L);
        authInfo.setEmail("head@gmail.com");
        authInfo.setPassword(passwordEncoder.encode("head"));
        authInfo.setRole(Role.HEADOF);
        headOf.setAuthInfo(authInfo);
        headOfRepository.save(headOf);
    }

    @PostConstruct
    public void init3() {
        Employee employee = new Employee();
        employee.setFirstName("employee");
        employee.setLastName("employee");
        employee.setId(1L);

        AuthInfo authInfo2 = new AuthInfo();
        authInfo2.setId(2L);
        authInfo2.setEmail("employee@gmail.com");
        authInfo2.setPassword(passwordEncoder.encode("employee"));
        authInfo2.setRole(Role.EMPLOYEE);
        employee.setAuthInfo(authInfo2);
        employeeRepository.save(employee);

    }
}
