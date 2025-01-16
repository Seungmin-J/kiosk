package kiosk.lv6.factory;

import kiosk.lv6.model.*;

import java.util.ArrayList;
import java.util.List;

public class MenuFactory {

    public static List<Menu> createMenus() {
        List<Menu> menus = new ArrayList<>();

        menus.add(new FoodMenu(1, Category.BURGERS));
        menus.add(new FoodMenu(2, Category.DRINKS));
        menus.add(new FoodMenu(3, Category.DESSERTS));
        menus.add(new SystemMenu(4, Category.ORDERS));
        menus.add(new SystemMenu(5, Category.CANCEL));
        return menus;
    }

    public static List<MenuItem> createBurgerItems() {
        List<MenuItem> list = new ArrayList<>();
        list.add(new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        list.add(new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        list.add(new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        list.add(new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));
        return list;
    }

    public static List<MenuItem> createDrinkItems() {
        List<MenuItem> list = new ArrayList<>();
        list.add(new MenuItem("Coke", 2000, "시원한 콜라"));
        list.add(new MenuItem("Lemonade", 2000, "상큼한 레몬에이드"));
        list.add(new MenuItem("Bubble tea", 2000, "펄이 들어간 버블티"));
        return list;
    }

    public static List<MenuItem> createDessertItems() {
        List<MenuItem> list = new ArrayList<>();
        list.add(new MenuItem("Carrot cake", 5500, "설탕대신 당근이 들어간 당근 케이크"));
        list.add(new MenuItem("Cookie", 2500, "내가 만든 쿠키"));
        list.add(new MenuItem("Doughnut", 3500, "던킨 도너츠"));
        return list;
    }


}
