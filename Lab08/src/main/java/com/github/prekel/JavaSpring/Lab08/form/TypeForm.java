package com.github.prekel.JavaSpring.Lab08.form;

import javax.validation.constraints.NotBlank;

public class TypeForm {
    @NotBlank(message = "Поле не должно быть пустым")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
