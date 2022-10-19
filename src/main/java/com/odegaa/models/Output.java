package com.odegaa.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "output")
public class Output {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    @ManyToOne
    private Warehouse warehouse_id;

    @ManyToOne
    private Currency currency_id;

    @Column(unique = true, nullable = false)
    private String factureNumber;

    @Column(unique = true, nullable = false)
    private String generationCode;

    @ManyToOne
    private Client client_id;

}