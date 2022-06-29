package com.example.fortylineshr.service;

import com.example.fortylineshr.dto.VacancyRequest;
import com.example.fortylineshr.dto.VacancyResponse;

import java.util.List;

public interface VacancyService {
    VacancyResponse create(VacancyRequest candidateRequest);

    VacancyResponse update(Long id, VacancyRequest candidateRequest);

    VacancyResponse getById(Long id);

    void deleteById(Long id);

    List<VacancyResponse> getAll();
}
