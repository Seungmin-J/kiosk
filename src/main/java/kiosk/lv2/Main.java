package kiosk.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        MenuItem shackBurger = new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem smokeShack = new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem cheeseburger = new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem hamburger = new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거");
        menuItems.add(shackBurger);
        menuItems.add(smokeShack);
        menuItems.add(cheeseburger);
        menuItems.add(hamburger);

        while (true) {
            String format = "%-1d. %-15s | W %.1f | %s\n";
            int index = 1;
            System.out.println("메뉴를 선택하세요\n");
            for (MenuItem item : menuItems) {
                System.out.printf(format, index++, item.name, item.price / 1000.0, item.description);
            }
            System.out.println("0. 프로그램 종료");
            switch (scanner.nextInt()) {
                case 1: System.out.printf(format, 1, menuItems.get(0).name, menuItems.get(0).price / 1000.0, menuItems.get(0).description+"\n");break;
                case 2: System.out.printf(format, 2, menuItems.get(1).name, menuItems.get(1).price / 1000.0, menuItems.get(1).description+"\n");break;
                case 3: System.out.printf(format, 3, menuItems.get(2).name, menuItems.get(2).price / 1000.0, menuItems.get(2).description+"\n");break;
                case 4: System.out.printf(format, 4, menuItems.get(3).name, menuItems.get(3).price / 1000.0, menuItems.get(3).description+"\n");break;
                case 0: {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                default: System.out.println("올바른 번호를 입력해주세요.\n");
            }
        }
    }

}
