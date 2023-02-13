package com.homebudget.homebudget.controller;

import com.homebudget.homebudget.entity.MutualFund;
import com.homebudget.homebudget.entity.Stock;
import com.homebudget.homebudget.repository.MutualRepository;
import com.homebudget.homebudget.service.MutualFundServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MutualFundsControllers {
    @Autowired
    private MutualRepository mutualRepository;

    @Autowired
    private MutualFundServices mutualFundServices;
    @PostMapping("/user/{id}/mutualFund")
    public MutualFund saveMutualFund(@PathVariable Long id, @RequestBody MutualFund mf) throws Exception {
        return mutualFundServices.saveMutualFund(id,mf);
    }

    @GetMapping("/mutualfund/{id}")
    public ResponseEntity<MutualFund> getMutualFundById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(mutualFundServices.getMutual(id));
    }

    @GetMapping("/allmutualfund/{userId}")
    public ResponseEntity<List<MutualFund>> getAllStockById(@PathVariable Long userId) throws Exception {
        return ResponseEntity.ok(mutualFundServices.getAllMutualFundByUserId(userId));
    }
    @PutMapping("/mutualfund/{id}")
    public ResponseEntity<MutualFund> updateMutualFund(@RequestBody MutualFund mf ,@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(mutualFundServices.updateMutualFund(id,mf));
    }
    @DeleteMapping("/del-mutualfund/{id}")
    public ResponseEntity<String> deleteStock(@PathVariable Long id) throws Exception {
        mutualFundServices.deleteMutualFund(id);
        return ResponseEntity.ok("MutualFund deleted");
    }


}
