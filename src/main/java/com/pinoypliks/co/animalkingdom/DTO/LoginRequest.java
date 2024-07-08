package com.pinoypliks.co.animalkingdom.DTO;

public class LoginRequest {
    private String UsernameorEmail;
    private String Password;

    LoginRequest(){}

    public LoginRequest(String usernameorEmail, String password) {
        UsernameorEmail = usernameorEmail;
        Password = password;
    }

    public String getUsernameorEmail() {
        return UsernameorEmail;
    }

    public String getPassword() {
        return Password;
    }

    public void setUsernameorEmail(String usernameorEmail) {
        UsernameorEmail = usernameorEmail;
    }

    public void setPassword(String password) {
        Password = password;
    }

    

    

}
