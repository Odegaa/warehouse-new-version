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
@Entity(name = "input")
public class Input {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateTimeFormat;

    @ManyToOne
    private Warehouse warehouse_id;

    @ManyToOne
    private Supplier supplier_id;

    @ManyToOne
    private Currency currency_id;

    @Column(nullable = false, unique = true)
    private String facture_number;

    @Column(unique = true, nullable = false)
    private String code;
}
