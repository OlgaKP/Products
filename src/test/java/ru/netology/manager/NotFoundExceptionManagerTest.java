package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class NotFoundExceptionManagerTest {
    private NotFoundExceptionManager manager = new NotFoundExceptionManager();
    private Product honor = new Smartphone(2, "Honor", 10000, "Hu");
    private Product game = new Book(1, "Game", 1000, "KA");

    @BeforeEach
    public void setUp() {
        manager.add(honor);
        manager.add(game);
    }

    @Test
    public void shouldDeleteId (){
        manager.removeById(1);

        Product[] actual = manager.getProducts();
        Product[] expected = new Product[]{honor};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldDeleteNotExistId (){
        manager.removeById(3);

        Product[] actual = manager.getProducts();
        Product[] expected = new Product[]{honor, game};
        assertArrayEquals(actual, expected);
    }
}
