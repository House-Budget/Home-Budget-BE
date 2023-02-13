package com.homebudget.homebudget.service;

import com.homebudget.homebudget.entity.Insurance;
import com.homebudget.homebudget.entity.Investment;
import com.homebudget.homebudget.entity.User;
import com.homebudget.homebudget.repository.InsuranceRepository;
import com.homebudget.homebudget.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InsuranceServices {
    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private UserRepository userRepository;

    public Insurance saveInsurance(Long userId, Insurance insurance) throws Exception {
        User user = userRepository.findById(userId).get();
        Investment investment  = user.getInvestment();
        insurance.setInvestment(investment);
        return this.insuranceRepository.save(insurance);
    }

    public Insurance getInsurance(Long insuranceId) throws Exception {
        Insurance insurance = insuranceRepository.findById(insuranceId).orElse(null);
        return insurance;
    }

    public List<Insurance> getAllInsuranceIdByUserId(Long userId) throws Exception{
        User user = userRepository.findById(userId).get();
        Investment investment = user.getInvestment();
        return investment.getInsurances();
    }
    public void deleteInsurance(Long insuranceId) throws Exception {
        Insurance insurance = insuranceRepository.findById(insuranceId).orElse(null);
        insuranceRepository.deleteById(insuranceId);
    }
    public Insurance updateInsurance(Long id, Insurance updatedInsurance) throws Exception {
        Insurance insurance = insuranceRepository.findById(id).get();
        insurance.setName(updatedInsurance.getName());
        insurance.setAmount(updatedInsurance.getAmount());
        return insuranceRepository.save(insurance);
    }
}
