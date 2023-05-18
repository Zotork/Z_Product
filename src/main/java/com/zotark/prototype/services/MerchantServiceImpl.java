package com.zotark.prototype.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zotark.prototype.Model.request.MerchantRegistrationRequest;
import com.zotark.prototype.Model.response.MerchantRegistrationResponse;
import com.zotark.prototype.entities.MerchantRoles;
import com.zotark.prototype.entities.Merchants;
import com.zotark.prototype.exceptions.RegistrationException;
import com.zotark.prototype.repostories.MerchantRepository;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantRepository merchantRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return merchantRepository.findByMerchantName(username).orElseThrow(()->new UsernameNotFoundException("Invalid Username"));
    }

    public MerchantRegistrationResponse registerMerchant(MerchantRegistrationRequest merchantRequest) throws RegistrationException{
        Merchants merchants = Merchants.builder()
                                      .merchantName(merchantRequest.getUsername())
                                      .password(merchantRequest.getPassword())
                                      .merchantType(merchantRequest.getMerchantType())
                                      .businessName(merchantRequest.getBusinessName())
                                      .businessSize(merchantRequest.getBusinessSize())
                                      .mobileNumber(merchantRequest.getMobileNumber())
                                      .merchantRoles(MerchantRoles.valueOf(merchantRequest.getRole()))
                                      .build();
        try{
            merchantRepository.save(merchants);
        }catch (Exception ex){
            throw new RegistrationException(ex.getMessage());
        }
        return MerchantRegistrationResponse.builder()
                                           .statusCode(200)
                                           .message("User created successfully")
                                           .build();
    }
    
}
