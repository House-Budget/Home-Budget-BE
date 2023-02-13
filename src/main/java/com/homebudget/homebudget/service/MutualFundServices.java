package com.homebudget.homebudget.service;

import com.homebudget.homebudget.entity.Insurance;
import com.homebudget.homebudget.entity.Investment;
import com.homebudget.homebudget.entity.MutualFund;
import com.homebudget.homebudget.entity.User;
import com.homebudget.homebudget.repository.MutualRepository;
import com.homebudget.homebudget.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MutualFundServices {
    @Autowired
    private MutualRepository mutualRepository;

    @Autowired
    private UserRepository userRepository;
    public MutualFund saveMutualFund(Long userId, MutualFund mf) throws Exception {
        User user = userRepository.findById(userId).get();
        Investment investment  = user.getInvestment();
        mf.setInvestment(investment);
        return this.mutualRepository.save(mf);
    }

    public MutualFund getMutual(Long mutualId) throws Exception {
        MutualFund mf = mutualRepository.findById(mutualId).orElse(null);
        return mf;
    }

    public List<MutualFund> getAllMutualFundByUserId(Long userId) throws Exception{
        User user = userRepository.findById(userId).get();
        Investment investment = user.getInvestment();
        return investment.getMutualFunds();
    }
    public void deleteMutualFund(Long mutualId) throws Exception {
        MutualFund stock = mutualRepository.findById(mutualId).orElse(null);
        mutualRepository.deleteById(mutualId);
    }
    public MutualFund updateMutualFund(Long id, MutualFund updatedMutualFund) throws Exception {
        MutualFund mf = mutualRepository.findById(id).get();
        mf.setName(updatedMutualFund.getName());
        mf.setAmount(updatedMutualFund.getAmount());
        return mutualRepository.save(mf);
    }

    public int getTotalAmount(long userId) {
        User user = this.userRepository.findById(userId).get();
        List<MutualFund> mfs = user.getInvestment().getMutualFunds();
        int totalAmount = 0;
        for(MutualFund mf : mfs) totalAmount+=mf.getAmount();
        return totalAmount;
    }

}
