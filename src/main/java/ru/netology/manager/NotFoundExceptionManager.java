package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.NotFoundExceptionRepository;

public class NotFoundExceptionManager {
    private NotFoundExceptionRepository repository = new NotFoundExceptionRepository();

    public NotFoundExceptionManager(NotFoundExceptionRepository repository) {
        this.repository = repository;
    }

    public NotFoundExceptionManager() {
    }

    public void add(Product item) {
        repository.save(item);
    }

    public void removeById(int id) {repository.removeById(id);}

    public Product[] getProducts() {
        Product[] items = repository.findAll();
        return items;
    }
}