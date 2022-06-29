package com.example.fortylineshr.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileUploadResponse {
    private Long fileId;

    private String fileType;
    private String message;
    private boolean uploadStatus;
    private String downloadUri;
}
