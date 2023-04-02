package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String image;
    private Double price;
    private String description;

    @ManyToOne
    @JoinColumn(name = "cat_id",referencedColumnName = "id")
    private Category category;
}
