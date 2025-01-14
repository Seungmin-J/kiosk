package kiosk.lv4;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> menuItems = new ArrayList<>();
    private String category;

    Menu(String category) {
        this.category = category;
    }

    public void printMenuItems() {
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
