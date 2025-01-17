package kiosk.lv6.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<MenuItem> cartList = new ArrayList<>();

    public List<MenuItem> getCartList() {
        return cartList;
    }
}
