package com.zotork.prototype.Model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MerchantRegistrationResponse {
    private int statusCode;
    private String message;
}
