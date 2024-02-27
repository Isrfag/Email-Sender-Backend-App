package com.emailSender.Send.Email.with.Springboot.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailDto {
    private String email_address;
    private String subject;
    private String message;

}
