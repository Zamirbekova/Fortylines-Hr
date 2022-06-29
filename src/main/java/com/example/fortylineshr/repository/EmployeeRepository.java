package com.example.fortylineshr.repository;

import com.example.fortylineshr.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select case when count(a)>0 then true else false end" +
            " from AuthInfo a where a.email =?1")
    boolean existsByEmail(String email);
}
