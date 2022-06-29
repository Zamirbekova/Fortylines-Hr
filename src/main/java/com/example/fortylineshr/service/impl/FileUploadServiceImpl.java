package com.example.fortylineshr.service.impl;

import com.example.fortylineshr.exceptionl.NotFoundException;
import com.example.fortylineshr.model.UploadedFile;
import com.example.fortylineshr.repository.FiileUploadRepository;
import com.example.fortylineshr.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service

public class FileUploadServiceImpl implements FileUploadService {
    private final String uploadFolderPath = "/Users/deomrinal/desktop/uploaded_";
    @Autowired
    private FiileUploadRepository fileUploadRepository;


    public UploadedFile uploadToDb(MultipartFile file) {

        UploadedFile uploadedFile = new UploadedFile();
        try {
            uploadedFile.setFileData(file.getBytes());
            uploadedFile.setFileType(file.getContentType());
            uploadedFile.setFileName(file.getOriginalFilename());
            return fileUploadRepository.save(uploadedFile);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public UploadedFile findById(Long id) {
        return fileUploadRepository.findById(id).orElseThrow(() -> new NotFoundException("not found"));
    }



    public void delete(Long id) {
        fileUploadRepository.deleteById(id);
    }
}
