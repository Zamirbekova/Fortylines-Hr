package com.example.fortylineshr.repository;

import com.example.fortylineshr.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacanciesRepository extends JpaRepository<Vacancy, Long> {
}
