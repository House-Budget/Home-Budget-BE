package com.homebudget.homebudget.controller;

import com.homebudget.homebudget.entity.Insurance;
import com.homebudget.homebudget.service.InsuranceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InsuranceController {

    @Autowired
    private InsuranceServices insuranceServices;

    @PostMapping("/user/{userId}/insurance")
    public Insurance saveInsurance(@PathVariable long id, @RequestBody Insurance insurance) throws Exception {
        return this.insuranceServices.saveInsurance(id,insurance);
    }

    @GetMapping("/insurance/{id}")
    public ResponseEntity<Insurance> getInsuranceById(@PathVariable long id) throws Exception {
        return ResponseEntity.ok(this.insuranceServices.getInsurance(id));
    }

    @GetMapping("/insurance/{userId}")
    public ResponseEntity<List<Insurance>>getAllInsuranceByUserId(@PathVariable long userId) throws Exception {
        return ResponseEntity.ok(this.insuranceServices.getAllInsuranceByUserId(userId));
    }
    @PutMapping("/insurance/{id}")
    public ResponseEntity<Insurance> updateInsuranceByUserId(@RequestBody Insurance insurance ,@PathVariable long id) throws Exception {
        return ResponseEntity.ok(this.insuranceServices.updateInsuranceByUserId(id,insurance));
    }
    @DeleteMapping("/del-insurance/{id}")
    public ResponseEntity<String> deleteInsuranceById(@PathVariable long id) throws Exception {
        this.insuranceServices.deleteInsuranceById(id);
        return ResponseEntity.ok("insurance deleted");
    }
    @GetMapping("/user/{userId}/insurance/total")
    public ResponseEntity<Long> getTotalMutualFund(@PathVariable long userId){
        return ResponseEntity.ok(this.insuranceServices.getTotalAmount(userId));
    }


}

