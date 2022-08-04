package ru.netology.domain;

public class Book extends Product{
    private String author;

    public Book(int id, String title, int cost, String author) {
        super(id, title, cost);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean matches(String search) {
        if (super.matches(search)) { // вызов метода matches в версии описанной в Product
            return true;
        }
        if (getAuthor().matches(search)) {
            return true;
        }
        return false;
    }
}

