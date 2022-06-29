package com.example.fortylineshr.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VacancyResponse {

    private Long id;
    private String vacancy;
    private String version;
    private String requirements;
}
