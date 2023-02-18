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

    @PostMapping("/user/{id}/insurance")
    public Insurance saveInsurance(@PathVariable long id, @RequestBody Insurance insurance) throws Exception {
        return insuranceServices.saveInsurance(id,insurance);
    }

    @GetMapping("/insurance/{id}")
    public ResponseEntity<Insurance> getInsuranceById(@PathVariable long id) throws Exception {
        return ResponseEntity.ok(insuranceServices.getInsurance(id));
    }

    @GetMapping("/all_insurance/{userId}")
    public ResponseEntity<List<Insurance>>getAllInsuranceByUserId(@PathVariable long userId) throws Exception {
        return ResponseEntity.ok(insuranceServices.getAllInsuranceByUserId(userId));
    }
    @PutMapping("/insurance/{id}")
    public ResponseEntity<Insurance> updateInsurance(@RequestBody Insurance insurance ,@PathVariable long id) throws Exception {
        return ResponseEntity.ok(insuranceServices.updateInsurance(id,insurance));
    }
    @DeleteMapping("/del_insurance/{id}")
    public ResponseEntity<String> deleteInsurance(@PathVariable long id) throws Exception {
        insuranceServices.deleteInsurance(id);
        return ResponseEntity.ok("insurance deleted");
    }

}
