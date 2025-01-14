package kiosk.lv4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Menu menu_burgers = new Menu("BURGERS");
        Menu menu_drinks = new Menu("DRINKS");
        Menu menu_desserts = new Menu("DESSERTS");
        List<Menu> menuList = new ArrayList<>();
        Collections.addAll(menuList, menu_burgers, menu_drinks, menu_desserts);

        menu_burgers.getMenuItems().add(new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menu_burgers.getMenuItems().add(new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menu_burgers.getMenuItems().add(new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menu_burgers.getMenuItems().add(new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Kiosk kiosk = new Kiosk(menuList);
        kiosk.start();
    }
}
