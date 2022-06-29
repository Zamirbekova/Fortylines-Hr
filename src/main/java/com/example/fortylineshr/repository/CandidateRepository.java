package com.example.fortylineshr.repository;

import com.example.fortylineshr.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Long> {
}
