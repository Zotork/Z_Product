package com.zotark.prototype.Model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MerchantRegistrationRequest {
    private String username;
    private String password;
    private String merchantType;
    private int businessSize;
    private String mobileNumber;
    private String businessName;
    private String role;
}
