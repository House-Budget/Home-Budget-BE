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
@Entity
@Table(name = "mutual_fund")
public class MutualFund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mutual_fund_id")
    private long Id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private long amount;

    @ManyToOne
    @Getter(onMethod = @__(@JsonIgnore))
    private Investment investment;

}
