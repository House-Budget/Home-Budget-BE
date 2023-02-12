package com.homebudget.homebudget.service;

import com.homebudget.homebudget.entity.Bank;
import com.homebudget.homebudget.entity.Investment;
import com.homebudget.homebudget.entity.User;
import com.homebudget.homebudget.repository.BankRepository;
import com.homebudget.homebudget.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {
    @Autowired
    BankRepository bankRepository;

    @Autowired
    UserRepository userRepository;

    public Bank save(long userId, Bank data) {
        User user = userRepository.findById(userId).get();
        Investment investment  = user.getInvestment();
        data.setInvestment(investment);
        return this.bankRepository.save(data);
    }

    public List<Bank> getAllBanks(long userId) {
        User user = this.userRepository.findById(userId).get();
        return user.getInvestment().getBanks();
    }

    public Bank updateBank(long bankId, Bank bankDetails) {
        Bank bank = findById(bankId);
        if (bank == null) {
            return null;
        }
        User user = bank.getInvestment().getUser();
        bank.setName(bankDetails.getName());
        bank.setAmount(bankDetails.getAmount());
        bank = save(user.getId(), bank);
        return bank;
    }

    public Bank findById(long id) {
        return bankRepository.findById(id).orElse(null);
    }

    public void delete(Bank Bank) {
        bankRepository.delete(Bank);
    }

}
