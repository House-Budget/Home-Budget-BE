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
    @PostMapping("/user/{userId}/mutual-fund")
    public MutualFund saveMutualFund(@PathVariable Long userId, @RequestBody MutualFund mf) throws Exception {
        return mutualFundServices.saveMutualFund(userId,mf);
    }

    @GetMapping("/mutual-fund/{id}")
    public ResponseEntity<MutualFund> getMutualFundById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(mutualFundServices.getMutual(id));
    }

    @GetMapping("/user/{userId}/mutual-fund")
    public ResponseEntity<List<MutualFund>> getAllMutualFundByUserId(@PathVariable Long userId) throws Exception {
        return ResponseEntity.ok(mutualFundServices.getAllMutualFundByUserId(userId));
    }
    @PutMapping("/mutual-fund/{id}")
    public ResponseEntity<MutualFund> updateMutualFund(@RequestBody MutualFund mf ,@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(mutualFundServices.updateMutualFund(id,mf));
    }
    @DeleteMapping("/mutual-fund/{id}")
    public ResponseEntity<String> deleteMutualFund(@PathVariable Long id) throws Exception {
        mutualFundServices.deleteMutualFund(id);
        return ResponseEntity.ok("MutualFund deleted");
    }


}
