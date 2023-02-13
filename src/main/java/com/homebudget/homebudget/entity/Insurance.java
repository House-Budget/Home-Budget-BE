package com.homebudget.homebudget.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "insurance")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "insurance_id")
    private long Id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int amount;

    @ManyToOne()
    @Getter(onMethod = @__(@JsonIgnore))
    private Investment investment;
}
