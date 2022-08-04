package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTests {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product101 = new Book(101, "1", 100, "author1");
    Product product102 = new Book(102, "2", 200, "author2");
    Product product103 = new Book(103, "3", 300, "manufacturer1");
    Product product104 = new Book(104, "4", 400, "author3");

    Product product201 = new Smartphone(201, "4", 100, "manufacturer1");
    Product product202 = new Smartphone(202, "5", 200, "manufacturer2");
    Product product203 = new Smartphone(203, "6", 300, "manufacturer3");
    Product product204 = new Smartphone(204, "4 1", 400, "manufacturer3");


    @BeforeEach
    public void setup() {
        manager.add(product101);
        manager.add(product102);
        manager.add(product103);
        manager.add(product104);
        manager.add(product201);
        manager.add(product202);
        manager.add(product203);
        manager.add(product204);
    }
    //мы проверяем вхождение запроса в текст названия товара

    @Test
    public void shouldSearchBookByAuthor() {

        Product[] expected = {product101};
        Product[] actual = manager.searchBy("author1");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByManufacturer() {

        Product[] expected = {product203, product204};
        Product[] actual = manager.searchBy("manufacturer3");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneAndBookMatchInTheName() {

        Product[] expected = {product103, product201};
        Product[] actual = manager.searchBy("manufacturer1");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchBookByTitle() {

        Product[] expected = {product102};
        Product[] actual = manager.searchBy("2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByTitle() {

        Product[] expected = {product202};
        Product[] actual = manager.searchBy("5");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookAndSmartphoneByTitle() {

        Product[] expected = {product101, product204};
        Product[] actual = manager.searchBy("1");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindProductsWhenThereIsNoMatch() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("432");

        Assertions.assertArrayEquals(expected, actual);
    }
}



