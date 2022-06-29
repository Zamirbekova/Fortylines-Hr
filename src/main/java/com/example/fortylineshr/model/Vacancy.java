package com.example.fortylineshr.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vacancies")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Vacancy {
    @Id
    @SequenceGenerator(
            name = "vacancy_seq",
            sequenceName = "vacancy_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vacancy_seq"
    )
    private Long id;
    private String vacancy;
    private String version;
    private LocalDateTime time;
    private String requirements;
}
