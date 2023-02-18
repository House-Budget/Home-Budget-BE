package com.homebudget.homebudget.controller;
import com.homebudget.homebudget.entity.Stock;
import com.homebudget.homebudget.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StockController {


    @Autowired
    private StockService stockService;

    @PostMapping("/user/{id}/stock")
    public Stock saveStock(@Valid @PathVariable long id, @RequestBody Stock stock) throws Exception {
        return this.stockService.saveStock(id,stock);
    }

    @GetMapping("/stock/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable long id) {
        Stock stock = this.stockService.getStockById(id);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    @GetMapping("/stock/{userId}")
    public ResponseEntity<List<Stock>> getAllStockById(@PathVariable long userId) throws Exception {
        return ResponseEntity.ok(this.stockService.getAllStockByUserId(userId));
    }
    @PutMapping("/stock/{id}")
    public ResponseEntity<Stock> updateStock(@Valid @RequestBody Stock stock ,@PathVariable long id) throws Exception {
        return ResponseEntity.ok(this.stockService.updateStock(id,stock));
    }
    @DeleteMapping("/del-stock/{id}")
    public ResponseEntity<String> deleteStock(@PathVariable long id) throws Exception {
        this.stockService.deleteStock(id);
        return ResponseEntity.ok("Stock deleted");
    }
    @GetMapping("/user/{userid}/stock/total")
    public int gettotalAmount(@PathVariable long uid){
        return this.stockService.getTotalAmount(uid);
    }

}
