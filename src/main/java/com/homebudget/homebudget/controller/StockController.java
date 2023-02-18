package com.homebudget.homebudget.controller;

import com.homebudget.homebudget.entity.Stock;
import com.homebudget.homebudget.repository.StockRepository;
import com.homebudget.homebudget.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {
    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private StockService stockService;
    @PostMapping("/user/{id}/stock")
    public Stock saveStock(@PathVariable Long id, @RequestBody Stock stock) throws Exception {
        return stockService.saveStock(id,stock);
    }

    @GetMapping("/stocks/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable Long id) {
        Stock stock = this.stockService.getStock(id);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    @GetMapping("/all_stocks/{userId}")
    public ResponseEntity<List<Stock>> getAllStockById(@PathVariable Long userId) throws Exception {
        return ResponseEntity.ok(stockService.getAllStockByUserId(userId));
    }
    @PutMapping("/stocks/{id}")
    public ResponseEntity<Stock> updateStock(@RequestBody Stock stock ,@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(stockService.updateStock(id,stock));
    }
    @DeleteMapping("/del_stocks/{id}")
    public ResponseEntity<String> deleteStock(@PathVariable Long id) throws Exception {
        stockService.deleteStock(id);
        return ResponseEntity.ok("Stock deleted");
    }
    @GetMapping("/user/{uid}/total_stock_amt")
    public int gettotalAmount(@PathVariable Long uid){
        return stockService.getTotalAmount(uid);
    }

}
