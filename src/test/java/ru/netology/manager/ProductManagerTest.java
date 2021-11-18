package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductManagerTest {
    private ProductManager manager = new ProductManager();
    private Product honor = new Smartphone(2, "Honor", 10000, "Hu");
    private Product game = new Book(1, "Game", 1000, "KA");

    @BeforeEach
    public void setUp() {
        manager.add(honor);
        manager.add(game);
    }

    @Test
    public void shouldSearchOneSmartphoneByProducer() {
        Product[] actual = manager.searchBy("Hu");
        Product[] expected = new Product[]{honor};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchOneSmartphoneByName() {
        Product[] actual = manager.searchBy("Honor");
        Product[] expected = new Product[]{honor};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchOneBookByName() {
        Product[] actual = manager.searchBy("Game");
        Product[] expected = new Product[]{game};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchOneBookByAuthor() {
        Product[] actual = manager.searchBy("KA");
        Product[] expected = new Product[]{game};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchTrash() {
        Product[] actual = manager.searchBy("rt");
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchOneBookNonFullName() {
        Product[] actual = manager.searchBy("me");
        Product[] expected = new Product[]{game};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchOneSmartphoneNonFullName() {
        Product[] actual = manager.searchBy("Ho");
        Product[] expected = new Product[]{honor};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchSomePrice() {
        Product[] actual = manager.searchBy(Integer.toString(100));
        Product[] expected = new Product[]{honor, game};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchId() {
        Product honor = new Smartphone(20, "Honor", 10000, "Hu");
        manager.add(honor);
        Product game = new Book(11, "Game", 1000, "KA");
        manager.add(game);

        Product[] actual = manager.searchBy(Integer.toString(11));
        Product[] expected = new Product[]{game};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchName() {
        Product[] actual = manager.searchBy("Honor");
        Product[] expected = new Product[]{honor};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchNothing() {
        Product[] actual = manager.searchBy("");
        Product[] expected = new Product[]{honor,game};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchOtherProduct() {
        Product dress = new Product(101, "Dress", 500);
        manager.add(dress);

        Product[] actual = manager.searchBy("Dress");
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);
    }
}