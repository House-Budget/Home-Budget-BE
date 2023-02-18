package com.homebudget.homebudget.service;

import com.homebudget.homebudget.entity.Investment;
import com.homebudget.homebudget.entity.Stock;
import com.homebudget.homebudget.entity.User;
import com.homebudget.homebudget.exceptions.BadRequestException;
import com.homebudget.homebudget.repository.StockRepository;
import com.homebudget.homebudget.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        User user = this.userRepository.findById(userId).orElseThrow(()-> new BadRequestException("User does not exist"));
        Investment investment  = user.getInvestment();
        stock.setInvestment(investment);
        return this.stockRepository.save(stock);
    }

    public Stock getStock(Long stockId){
        Stock stock = stockRepository.findById(stockId).orElseThrow(()-> new BadRequestException("Stock not found with id: " + stockId));
        return stock;

    }

    public List<Stock> getAllStockByUserId(Long userId) throws Exception{
        User user = this.userRepository.findById(userId).orElseThrow(()-> new BadRequestException("User does not exist with id ,"+userId));
        Investment investment = user.getInvestment();
        return investment.getStocks();
    }
    public void deleteStock(Long stockId) throws Exception {
        Stock stock = this.stockRepository.findById(stockId).orElseThrow(()-> new BadRequestException("stock with id"+stockId+" does not exist"));
        stockRepository.deleteById(stockId);
    }
    public Stock updateStock(Long stockid, Stock updatedStock) throws Exception {
        Stock stock = this.stockRepository.findById(stockid).orElseThrow(()-> new BadRequestException("stock does not exist "+stockid));
        stock.setName(updatedStock.getName());
        stock.setAmount(updatedStock.getAmount());
        return stockRepository.save(stock);
    }
    public int getTotalAmount(long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(()-> new BadRequestException("user does not exist "+userId));
        List<Stock> stocks = user.getInvestment().getStocks();
        int totalAmount = 0;
        for(Stock st : stocks) totalAmount+=st.getAmount();
        return totalAmount;
    }

}