package kiosk.lv6.view;

import kiosk.lv6.model.Cart;
import kiosk.lv6.controller.KioskController;
import kiosk.lv6.model.DiscountType;

public class CartView {

    public static void printItemsInCart(KioskController kioskController) {
        if (!kioskController.isCartEmpty()) {
            String format = "%-15s | W %.1f | %s";
            System.out.println("장바구니에 담긴 메뉴: ");
            int cartSize = kioskController.getCart().getCartList().size();
            Cart cart = kioskController.getCart();
            for (int i = 0; i < cartSize; i++) {
                System.out.printf(
                        format,
                        cart.getCartList().get(i).getName(),
                        cart.getCartList().get(i).getPrice() / 1000.0,
                        cart.getCartList().get(i).getDescription() + "\n");
            }
        }
        System.out.println();
    }

    public static void printPrice(int price, DiscountType type) {
        String format = "총가격 : W %d";
        System.out.printf(format, (int) (price - (price * (type.getRate() / 100.0))));
        System.out.println();

    }
}
