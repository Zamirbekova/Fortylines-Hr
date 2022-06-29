package com.example.fortylineshr.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "head_of")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HeadOf {
    @Id
    @SequenceGenerator(
            name = "head_ofs_sequence",
            sequenceName = "head_ofs_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "head_ofs_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private AuthInfo authInfo;
}
