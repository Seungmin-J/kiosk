package kiosk.lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<MenuItem> menuItems = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    // 생성자 호출 시 MenuItem 객체 List에 add
    Kiosk(MenuItem... menuItem) {
        menuItems.addAll(Arrays.asList(menuItem));
    }

    public boolean start() {
        // 메뉴 출력 포멧
        String format = "%-1d. %-15s | W %.1f | %s\n";
        int index = 1;
        // 메뉴 출력
        System.out.println("메뉴를 선택하세요\n");
        for (MenuItem item : menuItems) {
            System.out.printf(format, index++, item.name, item.price / 1000.0, item.description);
        }
        System.out.println("0. 프로그램 종료");
        // 잘못된 번호 혹은 프로그램 종료 입력 시
        int menuSelection = scanner.nextInt();
        if(menuSelection > menuItems.size()) {
            System.out.println("올바른 번호를 입력해주세요.\n");
            return true;
        } else if (menuSelection == 0) {
            System.out.println("프로그램을 종료합니다.");
            return false;
        }
        // 선택한 메뉴 출력
        System.out.printf(
                format,
                menuSelection,
                menuItems.get(menuSelection-1).name,
                menuItems.get(menuSelection-1).price / 1000.0,
                menuItems.get(menuSelection-1).description+"\n");
        return true;
    }
}
