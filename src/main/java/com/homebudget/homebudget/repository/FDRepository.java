package com.homebudget.homebudget.repository;

import com.homebudget.homebudget.entity.FD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FDRepository extends JpaRepository<FD,Long> {
}
