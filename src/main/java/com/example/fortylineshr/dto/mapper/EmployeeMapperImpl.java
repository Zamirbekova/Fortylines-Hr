package com.example.fortylineshr.dto.mapper;

import com.example.fortylineshr.dto.EmployeeOfRequest;
import com.example.fortylineshr.dto.EmployeeOfResponse;
import com.example.fortylineshr.enums.Role;
import com.example.fortylineshr.model.AuthInfo;
import com.example.fortylineshr.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapperImpl {

    public Employee create(EmployeeOfRequest employeeOfRequest) {
        if (employeeOfRequest == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setFirstName(employeeOfRequest.getFirstName());
        employee.setLastName(employeeOfRequest.getLastName());

        AuthInfo authInfo = new AuthInfo();
        authInfo.setEmail(employeeOfRequest.getEmail());
        authInfo.setPassword(employeeOfRequest.getPassword());
        authInfo.setRole(Role.EMPLOYEE);

        employee.setAuthInfo(authInfo);
        return employee;
    }

    public Employee update(Employee employee, EmployeeOfRequest employeeOfRequest) {
        employee.setFirstName(employeeOfRequest.getFirstName());
        employee.setLastName(employeeOfRequest.getLastName());

        employee.getAuthInfo().setEmail(employeeOfRequest.getEmail());
        employee.getAuthInfo().setPassword(employeeOfRequest.getPassword());
        employee.getAuthInfo().setRole(Role.EMPLOYEE);

        return employee;
    }

    public EmployeeOfResponse convert(Employee employee) {

        EmployeeOfResponse employeeOfResponse = new EmployeeOfResponse();

        employeeOfResponse.setId(employee.getId());
        employeeOfResponse.setFirstName(employee.getFirstName());
        employeeOfResponse.setLastName(employee.getLastName());
        employeeOfResponse.setEmail(employee.getAuthInfo().getEmail());

        return employeeOfResponse;
    }

    public List<EmployeeOfResponse> deConvert(List<Employee> employees) {
        List<EmployeeOfResponse> employeeOfRespons = new ArrayList<>();
        for (Employee e : employees) {
            employeeOfRespons.add(convert(e));
        }
        return employeeOfRespons;
    }
}

