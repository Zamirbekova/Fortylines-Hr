package com.example.fortylineshr.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class VacancyRequest {

    private String vacancy;
    private String version;
    private LocalDateTime time;
    private String requirements;
}