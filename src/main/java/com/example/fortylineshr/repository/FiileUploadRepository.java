package com.example.fortylineshr.repository;

import com.example.fortylineshr.model.UploadedFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiileUploadRepository extends JpaRepository<UploadedFile,Long> {
}
