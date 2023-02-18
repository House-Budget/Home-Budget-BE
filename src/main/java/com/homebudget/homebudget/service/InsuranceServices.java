package com.homebudget.homebudget.service;
import com.homebudget.homebudget.entity.Insurance;
import com.homebudget.homebudget.entity.Investment;
import com.homebudget.homebudget.entity.User;
import com.homebudget.homebudget.exceptions.BadRequestException;
import com.homebudget.homebudget.repository.InsuranceRepository;
import com.homebudget.homebudget.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InsuranceServices {
    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private UserRepository userRepository;

    public Insurance saveInsurance(long userId, Insurance insurance) throws Exception {
        User user = this.userRepository.findById(userId).orElseThrow(()-> new BadRequestException("user not found "+userId));
        Investment investment  = user.getInvestment();
        insurance.setInvestment(investment);
        return this.insuranceRepository.save(insurance);
    }

    public Insurance getInsurance(long insuranceId) throws Exception {
        Insurance insurance = this.insuranceRepository.findById(insuranceId).orElseThrow(()-> new BadRequestException("Insurance not found "+insuranceId));
        return insurance;
    }

    public List<Insurance> getAllInsuranceByUserId(long userId) throws Exception{
        User user = this.userRepository.findById(userId).orElseThrow(()-> new BadRequestException("User not found "+userId));
        Investment investment = user.getInvestment();
        return investment.getInsurances();
    }
    public void deleteInsuranceById(long insuranceId) throws Exception {
        Insurance insurance = this.insuranceRepository.findById(insuranceId).orElseThrow(()-> new BadRequestException("Insurance not found "+insuranceId));
        this.insuranceRepository.deleteById(insuranceId);
    }
    public Insurance updateInsuranceByUserId(long id, Insurance updatedInsurance) throws Exception {
        Insurance insurance = this.insuranceRepository.findById(id).orElseThrow(()-> new BadRequestException("Insurance not found "+id));
        insurance.setName(updatedInsurance.getName());
        insurance.setAmount(updatedInsurance.getAmount());
        return this.insuranceRepository.save(insurance);
    }
    public long getTotalAmount(long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(()-> new BadRequestException("User not found "+userId));
        List<Insurance> insurances = user.getInvestment().getInsurances();
        long totalAmount = 0;
        for(Insurance ins : insurances) totalAmount+=ins.getAmount();
        return totalAmount;
    }
}
