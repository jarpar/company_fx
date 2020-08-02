package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public enum Category {
    KAROSERIA("karoseria"),
    ZAWIESZENIE("zawieszenie"),
    SILNIK("silnik");

    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }
}