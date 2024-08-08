package com.company.sigorta.dto;

import lombok.Data;

@Data
public class RegisterDto
{
    private String username;
    private String password;
    private String userEmail;
    private String firstName;
    private String lastName;
}