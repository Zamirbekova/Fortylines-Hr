package com.example.fortylineshr.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "admin")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Admin {
    @Id
    @SequenceGenerator(
            name = "admin_seq",
            sequenceName = "admin_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "admin_seq"
    )
    private Long id;
    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    private AuthInfo authInfo;


}
