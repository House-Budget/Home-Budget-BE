package com.homebuget.homebudget.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "investment")
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "investment_id")
    private long Id;

    @OneToOne
    private User user;

    @ManyToMany
    private List<Stock> stocks = new ArrayList<>();

    @ManyToMany
    private List<MutualFund> mutualFunds = new ArrayList<>();

    @ManyToMany
    private List<FD> fds = new ArrayList<>();

    @ManyToMany
    private List<Bank> banks = new ArrayList<>();

    @ManyToMany
    private List<Insurance> insurances = new ArrayList<>();
}
