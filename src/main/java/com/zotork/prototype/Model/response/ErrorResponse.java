package com.zotork.prototype.Model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ErrorResponse {
    private int statusCode;
    private String errorMessage;
}
