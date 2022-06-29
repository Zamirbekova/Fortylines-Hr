package com.example.fortylineshr.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "upload")
public class UploadedFile {

    @Id
    @SequenceGenerator(
            name = "upload_sequence",
            sequenceName = "upload_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "upload_sequence"
    )
    private Long fileId;
    private String fileName;
    private String fileType;
    @Lob
    private byte[] fileData;
}


