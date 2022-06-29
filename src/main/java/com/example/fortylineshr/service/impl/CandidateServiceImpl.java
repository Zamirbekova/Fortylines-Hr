package com.example.fortylineshr.service.impl;

import com.example.fortylineshr.dto.CandidateRequest;
import com.example.fortylineshr.dto.CandidateResponse;
import com.example.fortylineshr.dto.mapper.CandidateMapperImpl;
import com.example.fortylineshr.exceptionl.NotFoundException;
import com.example.fortylineshr.model.Candidate;
import com.example.fortylineshr.repository.CandidateRepository;
import com.example.fortylineshr.service.CandidateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final CandidateMapperImpl candidateMapper;
    private final CandidateRepository candidateRepository;

    @Override
    public CandidateResponse create(CandidateRequest candidateRequest) {
        return candidateMapper.convert(candidateRepository.save(candidateMapper.create(candidateRequest)));
    }

    @Override
    public CandidateResponse update(Long id, CandidateRequest candidateRequest) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(String.format("candidate with id = %s does not exists", id));
        });
        candidateMapper.update(candidate, candidateRequest);
        return candidateMapper.convert(candidateRepository.save(candidate));
    }

    @Override
    public CandidateResponse getById(Long id) {
        return candidateMapper.convert(candidateRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(String.format("candidate with id = %s does not exists", id));
        }));
    }

    @Override
    public void deleteById(Long id) {
        candidateRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(String.format("candidate with id = %s does not exists", id));
        });
        candidateRepository.deleteById(id);
    }

    @Override
    public List<CandidateResponse> getAll() {
        return candidateMapper.deConvert(candidateRepository.findAll());
    }
}

