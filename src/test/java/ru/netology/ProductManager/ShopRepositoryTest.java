package ru.netology.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    @Test
    public void testRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "стол", 10_000);
        Product product2 = new Product(2, "блокнот", 80);
        Product product3 = new Product(3, "гараж", 50_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "стол", 10_000);
        Product product2 = new Product(2, "блокнот", 80);
        Product product3 = new Product(3, "гараж", 50_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(15)
                );
    }

    @Test
    public void testShouldSaveProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "стол", 10_000);
        Product product2 = new Product(2, "блокнот", 80);
        Product product3 = new Product(3, "гараж", 50_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testShouldExceptionSaveProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "стол", 10_000);
        Product product2 = new Product(2, "блокнот", 80);
        Product product3 = new Product(3, "гараж", 50_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(AlreadyExistsException.class,
                () ->  repo.save(product1)
                );
    }

}