package com.homebudget.homebudget.controller;


import com.homebudget.homebudget.entity.Bank;
import com.homebudget.homebudget.entity.User;

import com.homebudget.homebudget.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BankController {
    @Autowired
    BankService bankService;

    @PostMapping("/user/{id}/bank")
    public ResponseEntity<String> saveBank(@PathVariable("id") long userId, @RequestBody Bank data) throws Exception{
        try{
            this.bankService.save(userId,data);
            return ResponseEntity.status(HttpStatus.CREATED).body("data added");
        }
        catch(Exception e){
            throw e;
        }

    }

    @GetMapping("/user/{id}/bank")
    public ResponseEntity<List<Bank>> getAllBanks(@PathVariable("id") long userId) throws Exception{
        try{
            List<Bank> banks = this.bankService.getAllBanks(userId);
            return ResponseEntity.ok().body(banks);
        }
        catch(Exception e){
            throw e;
        }

    }

    @GetMapping("/user/{id}/bank/total")
    public int getTotalAmount(@PathVariable("id") long userId) throws Exception{
        try{
            return this.bankService.getTotalAmount(userId);
        }
        catch(Exception e){
            throw e;
        }

    }

    @GetMapping("/bank/{id}")
    public  ResponseEntity<Bank>  getBank(@PathVariable("id") long id) throws Exception{
        Bank bank = bankService.findById(id);
        if (bank == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(bank);
    }

    @PutMapping("/bank/{id}")
    public ResponseEntity<Bank> updateBank(@PathVariable(value = "id") Long id,
                                         @Valid @RequestBody Bank bankDetails) {
        Bank bank = bankService.updateBank(id, bankDetails);
        if (bank == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bank);
    }

    @DeleteMapping("/bank/{id}")
    public ResponseEntity<Void> deleteBank(@PathVariable(value = "id") Long userId) {
        Bank bank = bankService.findById(userId);
        if (bank == null) {
            return ResponseEntity.notFound().build();
        }
        bankService.delete(bank);
        return ResponseEntity.noContent().build();
    }
}
