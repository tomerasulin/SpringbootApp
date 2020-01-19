package il.example.services;

import il.example.model.Item;

import java.util.Optional;


public interface ItemService {
    Iterable<Item> listAllItems();

    Item getItem(int id);

    void saveOrUpdateItem(Item item);

    void deleteItem(int id);
}
