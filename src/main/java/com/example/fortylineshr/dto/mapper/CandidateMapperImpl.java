package com.example.fortylineshr.dto.mapper;

import com.example.fortylineshr.dto.CandidateRequest;
import com.example.fortylineshr.dto.CandidateResponse;
import com.example.fortylineshr.model.Candidate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CandidateMapperImpl {

    public Candidate create(CandidateRequest candidateRequest) {
        if (candidateRequest == null) {
            return null;
        }
        Candidate candidate = new Candidate();
        candidate.setFirstName(candidateRequest.getFirstName());
        candidate.setLastName(candidateRequest.getLastName());
        candidate.setPhone(candidateRequest.getPhone());
        candidate.setEmail(candidateRequest.getEmail());
        candidate.setDepartment(candidateRequest.getDepartment());
        candidate.setSkype(candidateRequest.getSkype());
        candidate.setDiscord(candidateRequest.getDiscord());
        candidate.setDepartment(candidateRequest.getDepartment());
        candidate.setYearsOfExperience(candidateRequest.getYearsOfExperience());
        candidate.setDegree(candidateRequest.getDegree());

        return candidate;
    }

    public Candidate update(Candidate candidate, CandidateRequest candidateRequest) {
        candidate.setFirstName(candidateRequest.getFirstName());
        candidate.setLastName(candidateRequest.getLastName());
        candidate.setPhone(candidateRequest.getPhone());
        candidate.setEmail(candidateRequest.getEmail());
        candidate.setDepartment(candidateRequest.getDepartment());
        candidate.setSkype(candidateRequest.getSkype());
        candidate.setDiscord(candidateRequest.getDiscord());
        candidate.setDepartment(candidateRequest.getDepartment());
        candidate.setYearsOfExperience(candidateRequest.getYearsOfExperience());
        candidate.setDegree(candidateRequest.getDegree());

        return candidate;
    }

    public CandidateResponse convert(Candidate candidate) {
        CandidateResponse candidateResponse = new CandidateResponse();
        candidateResponse.setId(candidate.getId());
        candidateResponse.setFirstName(candidate.getFirstName());
        candidateResponse.setLastName(candidate.getLastName());
        candidateResponse.setPhone(candidate.getPhone());
        candidateResponse.setEmail(candidate.getEmail());
        candidateResponse.setDepartment(candidate.getDepartment());
        candidateResponse.setSkype(candidate.getSkype());
        candidateResponse.setDiscord(candidate.getDiscord());
        candidateResponse.setYearsOfExperience(candidate.getYearsOfExperience());
        candidateResponse.setDepartment(candidate.getDepartment());
        candidateResponse.setDegree(candidate.getDegree());

        return candidateResponse;
    }

    public List<CandidateResponse> deConvert(List<Candidate> candidates) {
        List<CandidateResponse> candidateResponses = new ArrayList<>();
        for (Candidate c : candidates) {
            candidateResponses.add(convert(c));
        }
        return candidateResponses;
    }
}
