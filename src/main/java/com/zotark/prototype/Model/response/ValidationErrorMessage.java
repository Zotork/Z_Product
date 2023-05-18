package com.zotark.prototype.Model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ValidationErrorMessage {
    private String errorField;
    private String errorMessage;
}
