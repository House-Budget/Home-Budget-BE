package com.homebudget.homebudget.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stock")
public class Stock {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private long Id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int amount;

    @ManyToOne()
    @Getter(onMethod = @__(@JsonIgnore))
    private Investment investment;

}
