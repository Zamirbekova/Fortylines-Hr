package com.example.fortylineshr.api;

import com.example.fortylineshr.dto.EmployeeOfRequest;
import com.example.fortylineshr.dto.EmployeeOfResponse;
import com.example.fortylineshr.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class EmployeeApi {

    private final EmployeeService employeeService;

    @PostMapping
    public EmployeeOfResponse create(@RequestBody EmployeeOfRequest employeeOfRequest) {
        return employeeService.create(employeeOfRequest);
    }

    @PutMapping("/update/{id}")
    public EmployeeOfResponse update(@PathVariable("id") Long id, @RequestBody EmployeeOfRequest employeeOfRequest) {
        return employeeService.update(id, employeeOfRequest);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','HEADOF')")
    public EmployeeOfResponse getById(@PathVariable("id") Long id) {
        return employeeService.getById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Long id) {
        employeeService.deleteById(id);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','HEADOF')")
    public List<EmployeeOfResponse> getAll() {
        return employeeService.getAll();
    }
}



