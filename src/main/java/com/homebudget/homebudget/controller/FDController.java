package com.homebudget.homebudget.controller;

import com.homebudget.homebudget.entity.Bank;
import com.homebudget.homebudget.entity.FD;
import com.homebudget.homebudget.entity.User;
import com.homebudget.homebudget.service.FDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FDController {

    @Autowired
    FDService fdService;

    @PostMapping("/user/{id}/fd")
    public ResponseEntity<String> saveFD(@PathVariable("id") long userId, @RequestBody FD data) throws Exception{
        try{
            this.fdService.save(userId,data);
            return ResponseEntity.status(HttpStatus.CREATED).body("data added");
        }
        catch(Exception e){
            throw e;
        }

    }

    @GetMapping("/user/{id}/fd")
    public List<FD> getAllFD(@PathVariable("id") long userId) throws Exception{
        try{
           return this.fdService.getAllFD(userId);
        }
        catch(Exception e){
            throw e;
        }

    }

    @GetMapping("/fd/{id}")
    public  ResponseEntity<FD>  getFD(@PathVariable("id") long id) throws Exception{
        FD fd = fdService.findById(id);
        if (fd == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(fd);
    }

    @PutMapping("/fd/{id}")
    public ResponseEntity<FD> updateFD(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody FD fdDetails) {
        FD fd = fdService.updateFD(id, fdDetails);
        if (fd == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fd);
    }

    @DeleteMapping("/fd/{id}")
    public ResponseEntity<Void> deleteFD(@PathVariable(value = "id") Long userId) {
        FD fd = fdService.findById(userId);
        if (fd == null) {
            return ResponseEntity.notFound().build();
        }
        fdService.delete(fd);
        return ResponseEntity.noContent().build();
    }
}
