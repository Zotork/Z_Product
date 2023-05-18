package com.zotark.prototype.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zotark.prototype.Model.request.MerchantRegistrationRequest;
import com.zotark.prototype.Model.response.MerchantRegistrationResponse;
import com.zotark.prototype.exceptions.RegistrationException;
import com.zotark.prototype.services.MerchantService;

@RestController
@RequestMapping("/merchant")
public class MerchantController {
    @Autowired
    private MerchantService merchantService;

    @PostMapping("/register")
    public ResponseEntity<MerchantRegistrationResponse> registerMerchant(@RequestBody MerchantRegistrationRequest mRequest) throws RegistrationException{
        return ResponseEntity.status(HttpStatus.OK.value()).body(merchantService.registerMerchant(mRequest));
    }
}
