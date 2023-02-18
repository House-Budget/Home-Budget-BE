package com.homebudget.homebudget.controller;

import com.homebudget.homebudget.entity.MutualFund;
import com.homebudget.homebudget.service.MutualFundServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MutualFundsControllers {


    @Autowired
    private MutualFundServices mutualFundServices;
    
    @PostMapping("/user/{id}/mutual_fund")
    public MutualFund saveMutualFund(@Valid @PathVariable long id, @RequestBody MutualFund mf) throws Exception {
        return this.mutualFundServices.saveMutualFund(id,mf);
    }

    @GetMapping("/mutual_fund/{id}")
    public ResponseEntity<MutualFund> getMutualFundById(@PathVariable long id) throws Exception {
        return ResponseEntity.ok(this.mutualFundServices.getMutualFundById(id));
    }

    @GetMapping("/all_mutual_fund/{userId}")
    public ResponseEntity<List<MutualFund>> getAllMutualFundByUserId(@PathVariable long userId) throws Exception {
        return ResponseEntity.ok(this.mutualFundServices.getAllMutualFundByUserId(userId));
    }
    @PutMapping("/mutual_fund/{id}")
    public ResponseEntity<MutualFund> updateMutualFundById(@Valid @RequestBody MutualFund mf ,@PathVariable long id) throws Exception {
        return ResponseEntity.ok(this.mutualFundServices.updateMutualFundById(id,mf));
    }
    @DeleteMapping("/del_mutual_fund/{id}")
    public ResponseEntity<String> deleteMutualFundById(@PathVariable long id) throws Exception {
        this.mutualFundServices.deleteMutualFundById(id);
        return ResponseEntity.ok("MutualFund deleted");
    }

    @GetMapping("/user/{userId}/mutual-fund/total")
    public ResponseEntity<Long> getTotalMutualFund(@PathVariable long userId){
        return ResponseEntity.ok(this.mutualFundServices.getTotalMutualFund(userId));
    }


}
