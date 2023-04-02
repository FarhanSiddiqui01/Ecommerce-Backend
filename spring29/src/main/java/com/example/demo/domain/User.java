package com.example.demo.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String contact;
    private LocalDate createdAt;
    @JsonIgnore
    @OneToOne(mappedBy = "createdBy",cascade = CascadeType.ALL,orphanRemoval = true)
    private Cart cart;
}
