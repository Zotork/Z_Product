package com.zotark.prototype.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.zotark.prototype.Model.request.MerchantRegistrationRequest;
import com.zotark.prototype.Model.response.MerchantRegistrationResponse;
import com.zotark.prototype.exceptions.RegistrationException;

public interface MerchantService extends UserDetailsService {
    MerchantRegistrationResponse registerMerchant(MerchantRegistrationRequest merchantRegistrationRequest) throws RegistrationException;
}
