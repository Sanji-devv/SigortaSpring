package com.company.sigorta.dto;

public class UserDto
{
    private Integer userId;
    private String userName;
    private String userSurname;
    private String userEmail;

    public UserDto() {}

    public UserDto(Integer userId, String userName, String userSurname, String userEmail)
    {
        this.userId = userId;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userEmail = userEmail;
    }

    public Integer getUserId() { return userId; }

    public void setUserId(Integer id) { this.userId = id; }

    public String getUserName() { return userName; }

    public void setUserName(String name) { this.userName = name; }

    public String getUserSurname() { return userSurname; }

    public void setUserSurname(String surname) { this.userSurname = surname; }

    public String getUserEmail() { return userEmail; }

    public void setUserEmail(String email) { this.userEmail = email; }

    @Override
    public String toString() { return String.format("User info ID: %d\nName: %s\nSurname: %s\nEmail: %s", userId, userName, userSurname, userEmail); }
}
