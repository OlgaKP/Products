package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class NotFoundExceptionManagerTest {

    @Test
    public void shouldDeleteId (){
        NotFoundExceptionManager manager = new NotFoundExceptionManager();

        Product honor = new Smartphone(2, "Honor", 10000, "Hu");
        manager.add(honor);
        Product game = new Book(1, "Game", 1000, "KA");
        manager.add(game);
        manager.removeById(1);

        Product[] actual = manager.getProducts();
        Product[] expected = new Product[]{honor};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldDeleteNonId (){
        NotFoundExceptionManager manager = new NotFoundExceptionManager();

        Product honor = new Smartphone(2, "Honor", 10000, "Hu");
        manager.add(honor);
        Product game = new Book(1, "Game", 1000, "KA");
        manager.add(game);
        manager.removeById(3);

        Product[] actual = manager.getProducts();
        Product[] expected = new Product[]{honor, game};
        assertArrayEquals(actual, expected);
    }
}
