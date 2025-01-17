package kiosk.lv6;

import kiosk.lv6.controller.KioskController;
import kiosk.lv6.factory.MenuFactory;
import kiosk.lv6.model.DiscountType;

public class Main {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk(new KioskController(MenuFactory.createMenus()));
        kiosk.start();
    }
}
