package com.github.blacky0x0.charts.algebra.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * User: blacky
 * Date: 24.02.15
 */
public enum Law {

    COMMUNICATIVE(
            "Переместительный",
            "x v y = y v x",
            "xy = yx"
    ),

    ASSOCIATE(
            "Сочетательный",
            "x v (y v z) = (x v y) v z",
            "(xy)z = x(yz)"
    ),

    DISTRIBUTIVE(
            "Распределительный",
            "x(y v z) = xy v xz",
            "x v yz = (x v y)(y v z)"
    ),

    DE_MORGAN(
            "Правило де Моргана",
            "~(x v y) = ~x * ~y",
            "~(x * y) = ~x v ~y"
    ),

    IDENTITY(
            "Идемпотенция",
            "x v x = x",
            "x x = x"
    ),

    REDUNDANCE(
            "Поглощения",
            "x v xy  = x",
            "x(x v y) = x"
    ),

    GLUING(
            "Склеивания",
            "(x * y) v (~x * y) = y",
            "(x v y) * (~x v y) = y"
    ),

    COMPLEMENT(
            "С инверсией самого себя",
            "x v ~x = 1",
            "x * ~x = 0 "
    ),

    ANNULMENT(
            "С константой",
            "x v 0 = x, x v 1 = 1",
            "x * 0 = 0, x * 1 = x"
    ),

    DOUBLE_NEGATION(
            "Двойное отрицание",
            "~~x = x",
            ""
    );

    private StringProperty name;
    private StringProperty orOperation;
    private StringProperty andOperation;

    private Law(String name, String orOperation, String andOperation) {
        this.name = new SimpleStringProperty(name);
        this.orOperation = new SimpleStringProperty(orOperation);
        this.andOperation = new SimpleStringProperty(andOperation);
    }

    // Properties are used in table element via reflection
    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty orOperationProperty() {
        return orOperation;
    }

    public StringProperty andOperationProperty() {
        return andOperation;
    }

}
