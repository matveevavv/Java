package lab23CollectionsGenerics;

import lab1.Clothes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.UUID;

public class ShoppingCart <T extends Clothes> implements Serializable {
    ArrayList<T> cart;
    TreeSet<UUID> uuids;

    public ShoppingCart() {

        this.cart = new ArrayList<>();
        this.uuids = new TreeSet<>();
    }

    public TreeSet<UUID> getUuids() {
        return uuids;
    }

    public boolean add(T clothes) {
        uuids.add(clothes.getUUID());
        return this.cart.add(clothes);
    }

    public void delete(T clothes) {
        this.cart.remove(clothes);
//        uuids.remove(clothes.ID);
    }
//показать все объекты
    public void show() {
        for (T clothes : cart) {
            clothes.read();
        }
    }

    public void sokrashenyiShow() {
        for (T clothes : cart){
            System.out.println(clothes.name+"("+clothes.ID+")");
        }
    }

    //поиск объекта по идентификатору
    public boolean isExistsUUID(UUID id) {
        return uuids.contains(id);
    }
}
