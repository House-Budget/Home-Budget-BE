package com.homebudget.homebudget.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class MutualFund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mutualFund_id")
    private long Id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private long Amount;
    @Column(nullable = false)
    @ManyToOne
    @Getter(onMethod = @__(@JsonIgnore))
    private Investment investment;

}
