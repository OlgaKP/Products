package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductManagerTest {

    @Test
    public void shouldSearchOneSmartphoneByProducer() {
        ProductManager manager = new ProductManager();

        Product honor = new Smartphone(2, "Honor", 10000, "Hu");
        manager.add(honor);
        Product game = new Book(1, "Game", 1000, "KA");
        manager.add(game);

        Product[] actual = manager.searchBy("Hu");
        Product[] expected = new Product[]{honor};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchOneSmartphoneByName() {
        ProductManager manager = new ProductManager();

        Product honor = new Smartphone(2, "Honor", 10000, "Hu");
        manager.add(honor);
        Product game = new Book(1, "Game", 1000, "KA");
        manager.add(game);

        Product[] actual = manager.searchBy("Honor");
        Product[] expected = new Product[]{honor};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchOneBookByName() {
        ProductManager manager = new ProductManager();

        Product honor = new Smartphone(2, "Honor", 10000, "Hu");
        manager.add(honor);
        Product game = new Book(1, "Game", 1000, "KA");
        manager.add(game);

        Product[] actual = manager.searchBy("Game");
        Product[] expected = new Product[]{game};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchOneBookByAuthor() {
        ProductManager manager = new ProductManager();

        Product honor = new Smartphone(2, "Honor", 10000, "Hu");
        manager.add(honor);
        Product game = new Book(1, "Game", 1000, "KA");
        manager.add(game);

        Product[] actual = manager.searchBy("KA");
        Product[] expected = new Product[]{game};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchTrash() {
        ProductManager manager = new ProductManager();

        Product honor = new Smartphone(2, "Honor", 10000, "Hu");
        manager.add(honor);
        Product game = new Book(1, "Game", 1000, "KA");
        manager.add(game);

        Product[] actual = manager.searchBy("rt");
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchOneBookNonFullName() {
        ProductManager manager = new ProductManager();

        Product honor = new Smartphone(2, "Honor", 10000, "Hu");
        manager.add(honor);
        Product game = new Book(1, "Game", 1000, "KA");
        manager.add(game);

        Product[] actual = manager.searchBy("me");
        Product[] expected = new Product[]{game};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchOneSmartphoneNonFullName() {
        ProductManager manager = new ProductManager();

        Product honor = new Smartphone(2, "Honor", 10000, "Hu");
        manager.add(honor);
        Product game = new Book(1, "Game", 1000, "KA");
        manager.add(game);

        Product[] actual = manager.searchBy("Ho");
        Product[] expected = new Product[]{honor};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchSomePrice() {
        ProductManager manager = new ProductManager();

        Product honor = new Smartphone(2, "Honor", 10000, "Hu");
        manager.add(honor);
        Product game = new Book(1, "Game", 1000, "KA");
        manager.add(game);

        Product[] actual = manager.searchBy(Integer.toString(100));
        Product[] expected = new Product[]{honor, game};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchId() {
        ProductManager manager = new ProductManager();

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
        ProductManager manager = new ProductManager();

        Product honor = new Smartphone(20, "Honor", 10000, "Hu");
        manager.add(honor);
        Product book = new Book(11, "About Honor", 1000, "Uto");
        manager.add(book);

        Product[] actual = manager.searchBy("Honor");
        Product[] expected = new Product[]{honor, book};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchNothing() {
        ProductManager manager = new ProductManager();

        Product honor = new Smartphone(20, "Honor", 10000, "Hu");
        manager.add(honor);
        Product game = new Book(11, "Game", 1000, "KA");
        manager.add(game);

        Product[] actual = manager.searchBy("");
        Product[] expected = new Product[]{honor,game};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchOtherProduct() {
        ProductManager manager = new ProductManager();

        Product honor = new Smartphone(20, "Honor", 10000, "Hu");
        manager.add(honor);
        Product game = new Book(11, "Game", 1000, "KA");
        manager.add(game);
        Product dress = new Product(101, "Dress", 500);
        manager.add(dress);

        Product[] actual = manager.searchBy("Dress");
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);
    }
}