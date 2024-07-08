package com.pinoypliks.co.animalkingdom.DTO;

public class RegistrationRequest {
    private String Username;
    private String Email;
    private String Password;

    RegistrationRequest(){}

    public RegistrationRequest(String username, String email, String password) {
        Username = username;
        Email = email;
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    

}
