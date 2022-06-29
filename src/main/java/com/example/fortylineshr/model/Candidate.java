package com.example.fortylineshr.model;

import com.example.fortylineshr.enums.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "candidates")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Candidate {

    @Id
    @SequenceGenerator(
            name = "candidate_seq",
            sequenceName = "candidate_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "candidate_seq"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String skype;
    private String discord;
    private String department;
    private Department language;
    private String yearsOfExperience;
    private String degree;

}
