package com.example.fortylineshr.api;


import com.example.fortylineshr.dto.HeadOfRequest;
import com.example.fortylineshr.dto.HeadOfResponse;
import com.example.fortylineshr.service.HeadOfService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heads")
@PreAuthorize("hasAnyAuthority('ADMIN')")
@RequiredArgsConstructor
public class HeadOfApi {

    private final HeadOfService headOfService;

    @PostMapping
    public HeadOfResponse create(@RequestBody HeadOfRequest headOfRequest) {
        return headOfService.create(headOfRequest);
    }

    @PutMapping("/update/{id}")
    public HeadOfResponse update(@PathVariable("id") Long id, @RequestBody HeadOfRequest headOfRequest) {
        return headOfService.update(id, headOfRequest);
    }

    @GetMapping("/{id}")
    public HeadOfResponse getById(@PathVariable("id") Long id) {
        return headOfService.getById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Long id) {
        headOfService.deleteById(id);
    }

    @GetMapping
    public List<HeadOfResponse> getAll() {
        return headOfService.getAll();
    }
}

