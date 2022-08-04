package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.RuntimeException.NotFoundException;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

public class ProductRepositoryTests {

    private ProductRepository repo = new ProductRepository();

    Product product1 = new Book(1, "1", 100, "author1");
    Product product2 = new Book(2, "2", 200, "author2");
    Product product3 = new Book(3, "3", 300, "author3");

    Product product4 = new Smartphone(4, "4", 100, "manufacturer1");
    Product product5 = new Smartphone(5, "5", 200, "manufacturer2");
    Product product6 = new Smartphone(6, "6", 300, "manufacturer3");

    @Test
    public void shouldAddProduct() {
        repo.save(product1);
        repo.save(product3);
        repo.save(product5);

        Product[] expected = {product1, product3, product5};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);

        repo.removeById(2);
        repo.removeById(5);

        Product[] expected = {product1, product3, product4, product6};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveANonExistentId() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(300);
        });
    }
}
