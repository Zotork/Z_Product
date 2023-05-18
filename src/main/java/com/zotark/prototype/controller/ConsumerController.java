package com.zotark.prototype.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zotark.prototype.Model.request.ConsumerRegisterRequest;
import com.zotark.prototype.Model.response.ConsumerRegistrationResponse;
import com.zotark.prototype.exceptions.RegistrationException;
import com.zotark.prototype.services.ConsumerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/consumer")
public class ConsumerController {
    
    @Autowired
    private ConsumerService consumerService;

    @PostMapping("/register")
    public ResponseEntity<ConsumerRegistrationResponse> registerConsumer(@Valid @RequestBody ConsumerRegisterRequest consumerRegisterRequest) throws RegistrationException{
        return ResponseEntity.status(HttpStatus.OK.value()).body(consumerService.registerConsumer(consumerRegisterRequest));
    }
}
