package com.zotark.prototype.Model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsumerRegisterRequest {
    @NotBlank(message = "User name needed")
    private String consumerName;

    @NotBlank(message = "Password needed")
    private String password;

    @NotNull(message = "Mobile Number needed")
    private Long mobileNumber;

    @NotBlank(message = "Preferred Name needed")
    private String prefferedName;

    @NotBlank(message = "Role needed")
    private String role;
}
