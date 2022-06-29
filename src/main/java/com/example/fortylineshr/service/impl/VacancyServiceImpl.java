package com.example.fortylineshr.service.impl;

import com.example.fortylineshr.dto.VacancyRequest;
import com.example.fortylineshr.dto.VacancyResponse;
import com.example.fortylineshr.dto.mapper.VacancyMapperImpl;
import com.example.fortylineshr.exceptionl.NotFoundException;
import com.example.fortylineshr.model.Vacancy;
import com.example.fortylineshr.repository.VacanciesRepository;
import com.example.fortylineshr.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {

    private final VacancyMapperImpl vacancyMapper;
    private final VacanciesRepository vacancyRepository;

    @Override
    public VacancyResponse create(VacancyRequest vacancyRequest) {
        return vacancyMapper.convert(vacancyRepository.save(vacancyMapper.create(vacancyRequest)));
    }

    @Override
    public VacancyResponse update(Long id, VacancyRequest vacancyRequest) {
        Vacancy vacancy = vacancyRepository.findById(id).orElseThrow(() -> {

            throw new NotFoundException(String.format("vacancy with id = %s does not exists", id));
        });
        vacancyMapper.update(vacancy, vacancyRequest);
        return vacancyMapper.convert(vacancyRepository.save(vacancy));
    }

    @Override
    public VacancyResponse getById(Long id) {
        return vacancyMapper.convert(vacancyRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(String.format("vacancy with id = %s does not exists", id));
        }));
    }

    @Override
    public void deleteById(Long id) {
        boolean exists = vacancyRepository.existsById(id);
        if (!exists) {
            throw new NotFoundException("not found");
        }
        vacancyRepository.deleteById(id);
    }


    @Override
    public List<VacancyResponse> getAll() {
        return vacancyMapper.deConvert(vacancyRepository.findAll());
    }
}


