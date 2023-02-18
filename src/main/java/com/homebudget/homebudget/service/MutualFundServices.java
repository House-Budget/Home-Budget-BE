package com.homebudget.homebudget.service;
import com.homebudget.homebudget.entity.Investment;
import com.homebudget.homebudget.entity.MutualFund;
import com.homebudget.homebudget.entity.User;
import com.homebudget.homebudget.exceptions.BadRequestException;
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
    public MutualFund saveMutualFund(long userId, MutualFund mf) throws Exception {
        User user = this.userRepository.findById(userId).orElseThrow(()-> new BadRequestException("User not found for id "+userId ));
        Investment investment  = user.getInvestment();
        mf.setInvestment(investment);
        return this.mutualRepository.save(mf);
    }

    public MutualFund getMutualFundById(long mutualFundId) throws Exception {
        MutualFund mf = this.mutualRepository.findById(mutualFundId).orElseThrow(()-> new BadRequestException("Mutual fund not found for id "+mutualFundId ));
        return mf;
    }

    public List<MutualFund> getAllMutualFundByUserId(long userId) throws Exception{
        User user = this.userRepository.findById(userId).orElseThrow(()-> new BadRequestException("User not found for id "+userId ));
        Investment investment = user.getInvestment();
        return investment.getMutualFunds();
    }
    public void deleteMutualFundById(long mutualFundId) throws Exception {
        MutualFund stock = this.mutualRepository.findById(mutualFundId).orElseThrow(()-> new BadRequestException("Mutual fund not found, id "+mutualFundId ));
        this.mutualRepository.deleteById(mutualFundId);
    }
    public MutualFund updateMutualFundById(long mutualFundId, MutualFund updatedMutualFund) throws Exception {
        MutualFund mf = this.mutualRepository.findById(mutualFundId).orElseThrow(()-> new BadRequestException("Mutual fund not found, id "+mutualFundId ));
        mf.setName(updatedMutualFund.getName());
        mf.setAmount(updatedMutualFund.getAmount());
        return this.mutualRepository.save(mf);
    }

    public long getTotalMutualFund(long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(()-> new BadRequestException("User not found, id "+userId ));
        List<MutualFund> mfs = user.getInvestment().getMutualFunds();
        long totalAmount = 0;
        for(MutualFund mf : mfs) totalAmount+=mf.getAmount();
        return totalAmount;
    }

}
