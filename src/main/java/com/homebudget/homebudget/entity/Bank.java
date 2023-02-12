package com.homebudget.homebudget.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_id")
    private long Id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int amount;

    @ManyToOne()
    @Getter(onMethod = @__(@JsonIgnore))
    private Investment investment;

}
