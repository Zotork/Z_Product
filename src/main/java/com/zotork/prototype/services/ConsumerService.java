package com.zotork.prototype.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zotork.prototype.Model.request.ConsumerRegisterRequest;
import com.zotork.prototype.Model.response.ConsumerRegistrationResponse;
import com.zotork.prototype.entities.Consumer;
import com.zotork.prototype.entities.ConsumerRoles;
import com.zotork.prototype.exceptions.RegistrationException;
import com.zotork.prototype.repostories.ConsumerRepository;

@Service
public class ConsumerService implements UserDetailsService {

    @Autowired
    private ConsumerRepository consumerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return consumerRepository.findByConsumerName(username).orElseThrow(()->new UsernameNotFoundException("Username not found"));
    }

    public ConsumerRegistrationResponse registerConsumer(ConsumerRegisterRequest consumerRegisterRequest) throws RegistrationException {
        Consumer consumer = Consumer.builder()
                            .consumerName(consumerRegisterRequest.getConsumerName())
                            .password(consumerRegisterRequest.getPassword())
                            .prefferedUsername(consumerRegisterRequest.getPrefferedName())
                            .mobileNumber(consumerRegisterRequest.getMobileNumber())
                            .role(ConsumerRoles.valueOf(consumerRegisterRequest.getRole()))
                            .build();
        if(consumerRepository.findByConsumerName(consumerRegisterRequest.getConsumerName()).isPresent()){
            throw new RegistrationException("Username already Exist");
        }else if(consumerRepository.findByMobileNumber(consumerRegisterRequest.getMobileNumber()).isPresent()){
            throw new RegistrationException("Mobile number already Exist");
        }else if(consumerRepository.findByPrefferedUsername(consumerRegisterRequest.getPrefferedName()).isPresent()){
            throw new RegistrationException("Preferred name already Exist");
        }else{
            consumerRepository.save(consumer);
        }
        return ConsumerRegistrationResponse.builder()
                                           .status(200)
                                           .message("User Created Successfully")
                                           .build();
    }
    
}
