package com.homebudget.homebudget.controller;

import com.homebudget.homebudget.entity.Stock;
import com.homebudget.homebudget.repository.StockRepository;
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
    private StockRepository stockRepository;

    @Autowired
    private StockService stockService;
    @PostMapping("/user/{userId}/stock")
    public Stock saveStock(@Valid @PathVariable Long userId, @RequestBody Stock stock) throws Exception {
        return stockService.saveStock(userId,stock);
    }

    @GetMapping("/stocks/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable Long id) {
        Stock stock = this.stockService.getStock(id);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/stocks")
    public ResponseEntity<List<Stock>> getAllStockByUserId(@PathVariable Long userId) throws Exception {
        return ResponseEntity.ok(stockService.getAllStockByUserId(userId));
    }
    @PutMapping("/stocks/{id}")
    public ResponseEntity<Stock> updateStock(@Valid @RequestBody Stock stock ,@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(stockService.updateStock(id,stock));
    }
    @DeleteMapping("/stocks/{id}")
    public ResponseEntity<String> deleteStock(@PathVariable Long id) throws Exception {
        stockService.deleteStock(id);
        return ResponseEntity.ok("Stock deleted");
    }
    @GetMapping("/user/{userId}/total_stock_amt")
    public int getTotalAmount(@PathVariable Long userId){
        return stockService.getTotalAmount(userId);
    }

}
