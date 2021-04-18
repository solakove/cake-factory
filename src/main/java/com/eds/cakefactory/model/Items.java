package com.eds.cakefactory.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "items")
public class Items {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    private double price;

    public Items() {

    }

    public Items(long id, String title, double price) {
        this.id = id;
        this.name = title;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Equals based on business key - the name of the cake
     * - it should be unique and not null
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Items items = (Items) o;
        return getName().equals(items.getName());
    }

    /**
     * Hashcode based on business key - the name of the cake
     * - it should be unique and not null
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
