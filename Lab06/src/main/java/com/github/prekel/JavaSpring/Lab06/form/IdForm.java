package com.github.prekel.JavaSpring.Lab06.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class IdForm {
    @NotNull(message = "Поле не должно быть пустым")
    @PositiveOrZero(message = "Должно быть не отрицательным")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
