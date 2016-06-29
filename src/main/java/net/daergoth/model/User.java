package net.daergoth.model;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 6822199753616710856L;

    private String email;

    private String password;

    public User() {

    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
