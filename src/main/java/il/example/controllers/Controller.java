package il.example.controllers;

import il.example.model.Item;
import il.example.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/")
    public String index() {
        return "Working!";
    }

    @GetMapping(value = "/itemList")
    public Iterable<Item> itemList(Model model) {
        Iterable<Item> items = itemService.listAllItems();
        return items;
    }

    @GetMapping(value = "/item/{num}")
    public String getItemDetails(@PathVariable int num) {
        Item item = itemService.getItem(num);
        return item.toString();
    }

    @PutMapping(value = "/item/{num}/withdrawal/{quantity}")
    public void withdrawItem(@PathVariable int num, @PathVariable int quantity) {
        Item item = itemService.getItem(num);
        int amount = item.getAmount();
        int newAmount = amount - quantity;
        if (newAmount < 0) {
            System.out.println("Cant withdraw from the inventory. The amount is less than the withdrawal!");
        } else {
            item.setAmount(newAmount);
            itemService.saveOrUpdateItem(item);
            System.out.println("Withdrawal success");
        }
    }

    @PutMapping(value = "/item/{num}/deposit/{quantity}")
    public void depositItem(@PathVariable int num, @PathVariable int quantity) {
        Item item = itemService.getItem(num);
        item.setAmount(item.getAmount() + quantity);
        itemService.saveOrUpdateItem(item);
        System.out.println("Deposit Success");
    }

    @PostMapping(value = "/item")
    public void addItem(@RequestBody Item item) {
        itemService.saveOrUpdateItem(item);
    }

    @DeleteMapping(value = "/item/{num}")
    public void deleteItem(@PathVariable int num) {
        itemService.deleteItem(num);
    }


}
