package ru.netology.domain;

public class Product {
    protected int id;
    protected String title;
    protected int cost;

    public Product(int id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean matches(String search) {
        if (getTitle().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
