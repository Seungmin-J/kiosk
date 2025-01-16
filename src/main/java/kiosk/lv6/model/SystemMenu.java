package kiosk.lv6.model;

import kiosk.lv6.controller.KioskController;
import kiosk.lv6.view.CartView;

import java.util.List;
import java.util.Scanner;

public class SystemMenu extends Menu{
    Scanner scanner = new Scanner(System.in);
    public SystemMenu(Integer id, Category category) {
        super(id, category);
    }

    @Override
    public boolean handleMenuAction(KioskController controller) {
        Cart cart = controller.getCart();
        if(cart == null) {
            System.out.println("올바른 번호를 입력해주세요");
            return false;
        }
        List<MenuItem> menuItems = cart.getItemsInCart();

        int price = 0;
        for (MenuItem item : menuItems) {
            price += item.getPrice();
        }

        System.out.println("장바구니에 담긴 상품을 주문하시겠습니까?");
        CartView.printItemsInCart(controller);
        CartView.printPrice(price);
        System.out.println("1. 확인       2. 취소");
        int yesOrNo = scanner.nextInt();
        if (yesOrNo == 2) {
            // 사용자가 취소를 선택한 경우 메서드 종료
            System.out.println("주문을 취소하였습니다.");
        }
        if(yesOrNo == 1) {
            System.out.println("구매완료");
            controller.clearCart();
            controller.setHasCartFalse();
        }
        return true;
    }
}
