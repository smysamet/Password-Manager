package com.example.passwordmanager;

public class PasswordEntry {
    private String website;
    private String email;
    private String password;

    public PasswordEntry() {
    }

    public PasswordEntry(String website, String email, String password) {
        this.website = website;
        this.email = email;
        this.password = password;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWebsite() {
        return website;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "PasswordEntry [website=" + website + ", email=" + email + ", password=" + password + "]";
    }
}
