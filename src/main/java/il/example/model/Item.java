package il.example.model;

import javax.persistence.*;

@Entity
@Table(name="ITEM")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemNo;

    @Column(name = "ITEM_NAME")
    private String name;

    @Column(name = "ITEM_AMOUNT")
    private int amount;

    @Column(name = "INV_CODE")
    private int inventoryCode;

    public Item() {

    }

    public Item(int itemNo, String name, int amount, int inventoryCode) {
        this.itemNo = itemNo;
        this.name = name;
        this.amount = amount;
        this.inventoryCode = inventoryCode;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(short itemNo) {
        this.itemNo = itemNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getInventoryCode() {
        return inventoryCode;
    }

    public void setInventoryCode(int inventoryCode) {
        this.inventoryCode = inventoryCode;
    }

    @Override
    public String toString() {
        return "Item{" + "item number=" + itemNo +
                ", name='" + name + "', amount=" + amount +
                ", inventory code=" + inventoryCode + "}";
    }
}
