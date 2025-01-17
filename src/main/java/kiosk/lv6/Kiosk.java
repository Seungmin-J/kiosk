package kiosk.lv6;

import kiosk.lv6.controller.KioskController;
import kiosk.lv6.model.Menu;
import kiosk.lv6.view.CartView;
import kiosk.lv6.view.MenuView;

public class Kiosk {
    private final KioskController kioskController;

    Kiosk(KioskController kioskController) {
        this.kioskController = kioskController;
    }

    public void start() {
        while (true) {
            // 메인 메뉴 출력
            MenuView.printMenus(kioskController);
            int categorySelection;

            categorySelection = kioskController.getMenuSelection(kioskController.getMenus());
            if(categorySelection == -1) return;

            // 선택한 메뉴를 담음
            Menu selectedMenu = kioskController.getMenu(categorySelection);

            // 선택한 메뉴아이템 출력
            boolean isEnded = selectedMenu.processMenuSelection(kioskController);
            if(!isEnded) {
                CartView.printItemsInCart(kioskController);
            }
        }
    }
}
