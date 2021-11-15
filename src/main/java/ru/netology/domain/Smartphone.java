package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Data
//@EqualsAndHashCode(callSuper = true)

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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//        Smartphone that = (Smartphone) o;
//        return Objects.equals(prodicer, that.prodicer);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), prodicer);
//    }
//
//    @Override
//    public String toString() {
//        return "Smartphone{" +
//                "prodicer='" + prodicer + '\'' +
//                '}';
//    }
}
