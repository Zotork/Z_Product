package com.zotork.prototype.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.zotork.prototype.Model.request.MerchantRegistrationRequest;
import com.zotork.prototype.Model.response.MerchantRegistrationResponse;
import com.zotork.prototype.exceptions.RegistrationException;

public interface MerchantService extends UserDetailsService {
    MerchantRegistrationResponse registerMerchant(MerchantRegistrationRequest merchantRegistrationRequest) throws RegistrationException;
}
