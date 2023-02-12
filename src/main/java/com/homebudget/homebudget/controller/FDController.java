package com.homebudget.homebudget.controller;

import com.homebudget.homebudget.entity.FD;
import com.homebudget.homebudget.service.FDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FDController {

    @Autowired
    FDService fdService;

    @PostMapping("/user/{id}/fd")
    public ResponseEntity<String> addFD(@PathVariable("id") long userId, @RequestBody FD data) throws Exception{
        try{
            this.fdService.addToFD(userId,data);
            return ResponseEntity.status(HttpStatus.CREATED).body("data added");
        }
        catch(Exception e){
            throw e;
        }

    }

    @GetMapping("/user/{id}/fd")
    public List<FD> getFDs(@PathVariable("id") long userId) throws Exception{
        try{
           return this.fdService.getFDs(userId);
        }
        catch(Exception e){
            throw e;
        }

    }

    @GetMapping("/user/{id}/fd/{fdId}")
    public List<FD> getFD(@PathVariable("id") long userId, @PathVariable("fdId") long fdId) throws Exception{
        try{
            return this.fdService.getFD(userId, fdId);
        }
        catch(Exception e){
            throw e;
        }

    }
}
