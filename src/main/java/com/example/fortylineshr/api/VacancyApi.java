package com.example.fortylineshr.api;


import com.example.fortylineshr.dto.VacancyRequest;
import com.example.fortylineshr.dto.VacancyResponse;
import com.example.fortylineshr.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacancies")
@RequiredArgsConstructor
public class VacancyApi {

    private final VacancyService vacancyService;


    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','HEADOF')")
    public VacancyResponse create(@RequestBody VacancyRequest vacancyRequest) {
        return vacancyService.create(vacancyRequest);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','HEADOF')")
    public VacancyResponse update(@PathVariable Long id, @RequestBody VacancyRequest vacancyRequest) {
        return vacancyService.update(id, vacancyRequest);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','HEADOF')")
    public VacancyResponse getById(@PathVariable Long id) {
        return vacancyService.getById(id);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','HEADOF')")
    public void deleteById(@PathVariable Long id) {
        vacancyService.deleteById(id);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','HEADOF')")
    public List<VacancyResponse> getAll() {
        return vacancyService.getAll();
    }
}

