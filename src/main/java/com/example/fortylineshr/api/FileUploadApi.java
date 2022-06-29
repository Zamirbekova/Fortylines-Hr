package com.example.fortylineshr.api;

import com.example.fortylineshr.dto.FileUploadResponse;
import com.example.fortylineshr.model.UploadedFile;
import com.example.fortylineshr.service.FileUploadService;
import com.example.fortylineshr.service.impl.FileUploadServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/uploadFile")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
public class FileUploadApi {
    private final FileUploadServiceImpl fileUploadService;


    @PostMapping(consumes = {"multipart/form-data"})
    @PreAuthorize("hasAnyAuthority('EMPLOYEE','ADMIN')")
    public FileUploadResponse uploadDb(@RequestParam("file") MultipartFile multipartFile) {
        UploadedFile uploadedFile = fileUploadService.uploadToDb(multipartFile);
        FileUploadResponse response = new FileUploadResponse();
        if (uploadedFile != null) {
            String downloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/v1/download/")
                    .path(String.valueOf(uploadedFile.getFileId()))
                    .toUriString();
            response.setDownloadUri(downloadUri);
            response.setFileId(uploadedFile.getFileId());
            response.setFileType(uploadedFile.getFileType());
            response.setUploadStatus(true);
            response.setMessage("File Uploaded Successfully!");
            return response;

        }
        response.setMessage("Oops 1 something went wrong please re-upload.");
        return response;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('EMPLOYEE','ADMIN')")
    public UploadedFile getById(@PathVariable Long id) {
        return fileUploadService.findById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('EMPLOYEE','ADMIN')")
    public void delete(@PathVariable Long id) {
        fileUploadService.delete(id);
    }


}


