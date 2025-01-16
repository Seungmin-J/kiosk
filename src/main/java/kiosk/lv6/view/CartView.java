package kiosk.lv6.view;

import kiosk.lv6.model.Cart;
import kiosk.lv6.controller.KioskController;

public class CartView {

    public static void printItemsInCart(KioskController kioskController) {
        if(kioskController.hasCart()) {
            String format = "%-15s | W %.1f | %s";
            System.out.println("장바구니에 담긴 메뉴: ");
            int cartSize = kioskController.getCart().getItemsInCart().size();
            Cart cart = kioskController.getCart();
            for (int i = 0; i < cartSize; i++) {
                System.out.printf(
                        format,
                        cart.getItemsInCart().get(i).getName(),
                        cart.getItemsInCart().get(i).getPrice() / 1000.0,
                        cart.getItemsInCart().get(i).getDescription() + "\n");
            }
        }
        System.out.println();
    }
    public static void printPrice(int price) {
        String format = "총가격 : W %.1f";
        System.out.printf(format, price / 1000.0);
        System.out.println();
    }
}
