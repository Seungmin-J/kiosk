package kiosk.lv5;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<MenuItem> menuItems = new ArrayList<>();
    private final String category;

    Menu(String category) {
        this.category = category;
    }

    public void printMenuItems() {
        // 선택된 카테고리의 메뉴들을 출력
        String format = "%-1d. %-15s | W %.1f | %s\n";
        int index = 1;
        System.out.println(String.format("[ %s MENU ]", this.category));
        List<MenuItem> menuItems = this.menuItems;
        for (MenuItem item : menuItems) {
            System.out.printf(format, index++, item.getName(), item.getPrice() / 1000.0, item.getDescription());
        }
        System.out.println("0. 뒤로가기");
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public String getCategory() {
        return category;
    }
}
