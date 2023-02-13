package com.homebudget.homebudget.service;

import com.homebudget.homebudget.entity.Investment;
import com.homebudget.homebudget.entity.Stock;
import com.homebudget.homebudget.entity.User;
import com.homebudget.homebudget.repository.StockRepository;
import com.homebudget.homebudget.repository.UserRepository;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import com.sun.xml.internal.ws.api.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public Stock saveStock( Long userId,Stock stock) throws Exception {
        User user = userRepository.findById(userId).get();
        Investment investment  = user.getInvestment();
        stock.setInvestment(investment);
        return this.stockRepository.save(stock);
    }

    public Stock getStock(Long stockId) throws Exception {
        Stock stock = stockRepository.findById(stockId).orElse(null);
        return stock;
    }

    public List<Stock> getAllStockByUserId(Long userId) throws Exception{
        User user = userRepository.findById(userId).get();
        Investment investment = user.getInvestment();
        return investment.getStocks();
    }
    public void deleteStock(Long stockId) throws Exception {
        Stock stock = stockRepository.findById(stockId).orElse(null);
        stockRepository.deleteById(stockId);
    }
    public Stock updateStock(Long id, Stock updatedStock) throws Exception {
        Stock stock = stockRepository.findById(id).get();
        stock.setName(updatedStock.getName());
        stock.setAmount(updatedStock.getAmount());
        return stockRepository.save(stock);
    }

}