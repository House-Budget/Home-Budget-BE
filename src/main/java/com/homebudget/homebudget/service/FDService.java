package com.homebudget.homebudget.service;

import com.homebudget.homebudget.entity.Bank;
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
    public FD save(long userId, FD data) {
        User user = userRepository.findById(userId).get();
        Investment investment  = user.getInvestment();
        data.setInvestment(investment);
       return this.fdRepository.save(data);
    }

    public List<FD> getAllFD(long userId) {
        User user = this.userRepository.findById(userId).get();
        return user.getInvestment().getFds();
    }
    public FD updateFD(long fdId, FD fdDetails ) {
        FD fd = findById(fdId);
        if (fd == null) {
            return null;
        }
        User user = fd.getInvestment().getUser();
        fd.setName(fdDetails.getName());
        fd.setAmount(fdDetails.getAmount());
        fd = save(user.getId(), fd);
        return fd;
    }
    public FD findById(long id) {
        return fdRepository.findById(id).orElse(null);
    }

    public void delete(FD fd) {
        fdRepository.delete(fd);
    }

    public int getTotalAmount(long userId) {
        User user = this.userRepository.findById(userId).get();
        List<FD> fds = user.getInvestment().getFds();
        int totalAmount = 0;
        for(FD fd : fds) totalAmount+=fd.getAmount();
        return totalAmount;
    }
}
