package com.company.sigorta.dto;

public class UserDto
{
    private Integer id;
    private String name;
    private String surname;
    private String email;

    public UserDto() {}

    public UserDto(Integer id, String name, String surname, String email)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() { return String.format("User info ID: %d\nName: %s\nSurname: %s\nEmail: %s", id, name, surname, email); }
}
