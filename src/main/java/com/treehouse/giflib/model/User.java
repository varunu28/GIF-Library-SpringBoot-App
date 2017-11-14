package com.treehouse.giflib.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @NotNull(message ="User id is required")
    @Size(min = 1,message = "password required for login")
    private String userId;

    @NotNull(message="is Required")
    @Size(min=1,message="is Required")
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}