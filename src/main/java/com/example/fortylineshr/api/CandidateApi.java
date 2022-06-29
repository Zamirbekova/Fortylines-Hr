package com.example.fortylineshr.api;

import com.example.fortylineshr.dto.CandidateRequest;
import com.example.fortylineshr.dto.CandidateResponse;
import com.example.fortylineshr.service.CandidateService;
import com.example.fortylineshr.service.impl.EmailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/candidates")
@RequiredArgsConstructor
public class CandidateApi {

    private final CandidateService candidateService;
    private final EmailServiceImpl emailService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','HEADOF','EMPLOYEE')")
    public CandidateResponse create(@RequestBody CandidateRequest candidateRequest) {
        emailService.sendSimpleMessage(candidateRequest.getEmail(), "career@fortylines.io", "we invite you for an interview");
        return candidateService.create(candidateRequest);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','HEADOF','EMPLOYEE')")
    public CandidateResponse update(@PathVariable Long id, @RequestBody CandidateRequest candidateRequest) {
        return candidateService.update(id, candidateRequest);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','HEADOF','EMPLOYEE')")
    public CandidateResponse getById(@PathVariable Long id) {
        return candidateService.getById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','HEADOF','EMPLOYEE')")
    public void deleteById(@PathVariable Long id) {
        candidateService.deleteById(id);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','HEADOF','EMPLOYEE')")

    public List<CandidateResponse> getAll() {
        return candidateService.getAll();
    }

}


