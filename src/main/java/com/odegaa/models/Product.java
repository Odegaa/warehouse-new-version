package com.odegaa.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String productName;

    @ManyToOne
    private Category category_id;

    @OneToOne
    private Attachment attachment_id;

    @Column(unique = true, nullable = false)
    private String code;

    @ManyToOne
    private Measurement measurement_id;

    private Boolean status;

}
