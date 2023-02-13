package com.homebudget.homebudget.repository;

import com.homebudget.homebudget.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {
}
