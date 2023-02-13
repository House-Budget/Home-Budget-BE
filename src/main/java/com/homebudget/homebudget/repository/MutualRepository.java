package com.homebudget.homebudget.repository;

import com.homebudget.homebudget.entity.MutualFund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MutualRepository extends JpaRepository<MutualFund,Long> {
}
