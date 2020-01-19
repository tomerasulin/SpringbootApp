package il.example.services;

import il.example.model.Item;
import il.example.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Iterable<Item> listAllItems() {
        Iterable<Item> items = itemRepository.findAll();
        return items;
    }

    @Override
    public Item getItem(int id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public void saveOrUpdateItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void deleteItem(int id) {
        itemRepository.deleteById(id);
    }
}
