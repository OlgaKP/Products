package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper = false)

public class Smartphone extends Product {
    private String producer;

    public Smartphone() { super();}

    public Smartphone(int id, String name, int price, String producer) {
        super(id, name, price);
        this.producer = producer;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
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
