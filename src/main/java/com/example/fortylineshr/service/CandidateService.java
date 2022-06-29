package com.example.fortylineshr.service;

import com.example.fortylineshr.dto.CandidateRequest;
import com.example.fortylineshr.dto.CandidateResponse;

import java.util.List;

public interface CandidateService {
    CandidateResponse create(CandidateRequest candidateRequest);

    CandidateResponse update(Long id, CandidateRequest candidateRequest);

    CandidateResponse getById(Long id);

    void deleteById(Long id);

    List<CandidateResponse> getAll();
}
