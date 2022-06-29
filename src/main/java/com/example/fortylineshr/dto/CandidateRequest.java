package com.example.fortylineshr.dto;

import com.example.fortylineshr.enums.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidateRequest {

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
