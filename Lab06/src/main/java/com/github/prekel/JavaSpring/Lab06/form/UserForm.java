package com.github.prekel.JavaSpring.Lab06.form;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class UserForm {
    @NotBlank(message = "Поле не должно быть пустым")
    @Length(min = 6, max = 20)
    public String username;
    @NotBlank(message = "Поле не должно быть пустым")
    @Length(min = 6, max = 20)
    public String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
