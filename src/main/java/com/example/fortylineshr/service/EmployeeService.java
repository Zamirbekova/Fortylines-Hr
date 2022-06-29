package com.example.fortylineshr.service;

import com.example.fortylineshr.dto.EmployeeOfRequest;
import com.example.fortylineshr.dto.EmployeeOfResponse;

import java.util.List;

public interface EmployeeService {
    EmployeeOfResponse create(EmployeeOfRequest employee);

    EmployeeOfResponse update(Long id, EmployeeOfRequest e);

    EmployeeOfResponse getById(Long id);

    void deleteById(Long id);

    List<EmployeeOfResponse> getAll();
}
