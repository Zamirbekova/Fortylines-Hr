package com.example.fortylineshr.service.impl;

import com.example.fortylineshr.dto.EmployeeOfRequest;
import com.example.fortylineshr.dto.EmployeeOfResponse;
import com.example.fortylineshr.dto.mapper.EmployeeMapperImpl;
import com.example.fortylineshr.exceptionl.BadRequestException;
import com.example.fortylineshr.exceptionl.NotFoundException;
import com.example.fortylineshr.model.Employee;
import com.example.fortylineshr.repository.EmployeeRepository;
import com.example.fortylineshr.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapperImpl employeeMapper;
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeOfResponse create(EmployeeOfRequest employeeOfRequest) {
        String email = employeeOfRequest.getEmail();
        boolean exists = employeeRepository.existsByEmail(email);
        if (exists) {
            throw new BadRequestException("this email already exists");
        }
        Employee employee = employeeRepository.save(employeeMapper
                .create(employeeOfRequest));
        return employeeMapper.convert(employee);
    }

    @Override
    public EmployeeOfResponse update(Long id, EmployeeOfRequest employeeOfRequest) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(String.format("employee with id = %s does not exists", id));
        });

        employeeMapper.update(employee, employeeOfRequest);
        return employeeMapper.convert(employeeRepository.save(employee));
    }

    @Override
    public EmployeeOfResponse getById(Long id) {
        return employeeMapper.convert(employeeRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(String.format("employee with id = %s does not exists", id));
        }));
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(String.format("employee with id = %s does not exists", id));
        });
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeOfResponse> getAll() {
        return employeeMapper.deConvert(employeeRepository.findAll());
    }


}


