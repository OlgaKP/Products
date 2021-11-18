package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper = false)

public class Smartphone extends Product {
    private String prodicer;

    public Smartphone() { super();}

    public Smartphone(int id, String name, int price, String prodicer) {
        super(id, name, price);
        this.prodicer = prodicer;
    }

    public String getProdicer() {
        return prodicer;
    }

    public void setProdicer(String prodicer) {
        this.prodicer = prodicer;
    }
}