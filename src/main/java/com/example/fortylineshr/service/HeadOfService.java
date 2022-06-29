package com.example.fortylineshr.service;

import com.example.fortylineshr.dto.HeadOfRequest;
import com.example.fortylineshr.dto.HeadOfResponse;
import com.example.fortylineshr.model.HeadOf;

import java.util.List;
import java.util.Map;

public interface HeadOfService {
    HeadOfResponse create(HeadOfRequest candidateRequest);
    HeadOfResponse update(Long id,HeadOfRequest candidateRequest);
    HeadOfResponse getById(Long id);
    void deleteById(Long id);
    List<HeadOfResponse> getAll();
}
