package kiosk.lv6.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<MenuItem> itemsInCart = new ArrayList<>();

    public List<MenuItem> getItemsInCart() {
        return itemsInCart;
    }
}
