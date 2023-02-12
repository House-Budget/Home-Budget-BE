package com.homebudget.homebudget.service;

import com.homebudget.homebudget.entity.FD;
import com.homebudget.homebudget.entity.Investment;
import com.homebudget.homebudget.entity.User;
import com.homebudget.homebudget.repository.FDRepository;
import com.homebudget.homebudget.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FDService {
    @Autowired
    FDRepository fdRepository;

    @Autowired
    UserRepository userRepository;
    public void addToFD(long userId, FD data) {
        User user = userRepository.findById(userId).get();
        Investment investment  = user.getInvestment();
        data.setInvestment(investment);
        this.fdRepository.save(data);
    }

    public List<FD> getFDs(long userId) {
        User user = this.userRepository.findById(userId).get();
        return user.getInvestment().getFds();
    }

//    public List<FD> getFD(long userId, long fdId) {
//        User user = this.userRepository.findById(userId).get();
//        return user.getInvestment().getFds();
//    }
}
