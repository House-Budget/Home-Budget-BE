package com.homebudget.homebudget.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToOne(cascade = CascadeType.ALL)
    @Getter(onMethod = @__(@JsonIgnore))
    private User user;

//    @ManyToMany(mappedBy = "investment", cascade = CascadeType.ALL)
//    private List<Stock> stocks = new ArrayList<>();
//
//    @ManyToMany(mappedBy = "investment", cascade = CascadeType.ALL)
//    private List<MutualFund> mutualFunds = new ArrayList<>();

    @OneToMany(mappedBy = "investment", cascade = CascadeType.ALL)
    private List<FD> fds = new ArrayList<>();
    @OneToMany(mappedBy = "investment", cascade = CascadeType.ALL)
    private List<MutualFund> MutualFunds = new ArrayList<>();
    @OneToMany(mappedBy = "investment", cascade = CascadeType.ALL)
    private List<Stock> Stocks = new ArrayList<>();

    @OneToMany(mappedBy = "investment", cascade = CascadeType.ALL)
    private List<Insurance> Insurances = new ArrayList<>();

    @ManyToMany(mappedBy = "investment", cascade = CascadeType.ALL)
    private List<Bank> banks = new ArrayList<>();

//    @ManyToMany(mappedBy = "investment", cascade = CascadeType.ALL)
//    private List<Insurance> insurances = new ArrayList<>();
}