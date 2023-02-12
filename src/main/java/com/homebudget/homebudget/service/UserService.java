package com.homebudget.homebudget.service;


import com.homebudget.homebudget.entity.Investment;
import com.homebudget.homebudget.repository.InvestmentRepository;
import com.homebudget.homebudget.repository.UserRepository;
import com.homebudget.homebudget.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InvestmentRepository investmentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(User user){
        String hashPwd = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPwd);
        user.setCreateDt(String.valueOf(new Date(System.currentTimeMillis())));
        Investment investment = new Investment();
        investment.setUser(user);
        this.investmentRepository.save(investment);
        return userRepository.save(user);

    }

    public User getUserById(long id) throws Exception{
      Optional<User> user =  userRepository.findById(id);
      if(user.isPresent()){
          return user.get();
      }
      throw  new RuntimeException();
    }
}
