package com.example.fortylineshr.service.impl;

import com.example.fortylineshr.dto.HeadOfRequest;
import com.example.fortylineshr.dto.HeadOfResponse;
import com.example.fortylineshr.dto.mapper.HeadOfMapperImpl;
import com.example.fortylineshr.exceptionl.BadRequestException;
import com.example.fortylineshr.exceptionl.NotFoundException;
import com.example.fortylineshr.model.HeadOf;
import com.example.fortylineshr.repository.HeadOfRepository;
import com.example.fortylineshr.service.HeadOfService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class HeadOfServiceImpl implements HeadOfService {

    private final HeadOfMapperImpl headOfMapper;
    private final HeadOfRepository headOfRepository;

    @Override
    public HeadOfResponse create(HeadOfRequest headOfRequest) {
        String email = headOfRequest.getEmail();
        boolean exists= headOfRepository.existsByEmail(email);
        if (exists){
            throw new BadRequestException("email already exists");
        }
        HeadOf headOf = headOfRepository.save(headOfMapper
                .create(headOfRequest));
        return headOfMapper.convert(headOf);
    }

    @Override
    public HeadOfResponse update(Long id, HeadOfRequest headOfRequest) {
        HeadOf headOf = headOfRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(String.format("Head of department with id = %s does not exists", id));
        });
        headOfMapper.update(headOf, headOfRequest);
        return headOfMapper.convert(headOfRepository.save(headOf));
    }

    @Override
    public HeadOfResponse getById(Long id) {
        return headOfMapper.convert(headOfRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(String.format("employee with id = %s does not exists", id));
        }));
    }

    @Override
    public void deleteById(Long id) {
        boolean exists= headOfRepository.existsById(id);
        if (!exists){
            throw new NotFoundException("not found");
        }
        headOfRepository.deleteById(id);
    }

    @Override
    public List<HeadOfResponse> getAll() {
        return headOfMapper.deConvert(headOfRepository.findAll());
    }


}
