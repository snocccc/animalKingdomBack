package com.pinoypliks.co.animalkingdom.DTO;

public class LoginRequest {
    private String usernameoremail;
    private String password;

    LoginRequest(){}

    public LoginRequest(String usernameoremail, String password) {
        this.usernameoremail = usernameoremail;
        this.password = password;
    }

    public String getUsernameorEmail() {
        return usernameoremail;
    }

    public String getPassword() {
        return password;
    }

    public void setUsernameorEmail(String usernameoremail) {
        this.usernameoremail = usernameoremail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    

}
