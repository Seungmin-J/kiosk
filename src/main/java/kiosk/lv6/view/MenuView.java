package kiosk.lv6.view;

import kiosk.lv6.model.FoodMenu;
import kiosk.lv6.model.Menu;
import kiosk.lv6.model.MenuItem;
import kiosk.lv6.controller.KioskController;

import java.util.List;

public class MenuView {

    public static void printMenus(KioskController controller) {
        int index = 1;
        // 카테고리 출력
        System.out.println("[ MAIN MENU ]");
        for (Menu menu : controller.getMenus()) {
            if(controller.isCartEmpty()){
                if(index == 4) System.out.println("[ ORDER MENU ]");

                System.out.println(index++ + ". " + menu.getCategory());
            } else {
                if(menu instanceof FoodMenu) {
                    System.out.println(index++ + ". " + menu.getCategory());
                }
            }
        }
        System.out.println("0. 종료");
    }

    public static void printMenuItems(FoodMenu menu) {
        // 선택된 카테고리의 메뉴들을 출력
        String format = "%-1d. %-15s | W %.1f | %s\n";
        int index = 1;
        System.out.println(String.format("[ %s MENU ]", menu.getCategory()));
        List<MenuItem> menuItems = menu.getMenuItems();
        for (MenuItem item : menuItems) {
            System.out.printf(format, index++, item.getName(), item.getPrice() / 1000.0, item.getDescription());
        }
        System.out.println("0. 뒤로가기");
    }

    public static void printSelectedItem(MenuItem item) {
        String format = "%-15s | W %.1f | %s\n";
        System.out.println("선택한 메뉴: ");
        System.out.printf(
                format,
                item.getName(),
                item.getPrice() / 1000.0,
                item.getDescription() + "\n");
    }
}
