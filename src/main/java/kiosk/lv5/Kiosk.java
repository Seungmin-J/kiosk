package kiosk.lv5;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    // 메뉴 필드
    private List<Menu> menus;
    Scanner scanner = new Scanner(System.in);

    Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    public void start() {
        while (true) {
            printCategory();
            int categorySelection = getCategorySelection();
            // 0 입력 시 종료
            if (categorySelection == 0) {
                System.out.println("시스템을 종료합니다");
                return;
            }
            Menu selectedMenu = menus.get(categorySelection-1);
            if (selectedMenu.getMenuItems().isEmpty()) {
                System.out.println("메뉴가 없습니다");
                continue;
            }
            int menuSelection = getMenuSelection(selectedMenu);
            if (menuSelection == 0) {
                System.out.println("뒤로 이동");
                continue;
            }
            printSelectedItem(categorySelection, menuSelection);
        }
    }

    private int getMenuSelection(Menu menu) {
        System.out.println("메뉴를 선택하세요\n");
        menu.printMenuItems();
        int menuSelection = scanner.nextInt();
        return menuSelection;
    }

    private int getCategorySelection() {
        int categorySelection;
        while (true) {
            try {
                System.out.print("카테고리를 선택하세요: ");
                categorySelection = scanner.nextInt();
                if (categorySelection >= 0 && categorySelection <= menus.size()) {
                    return categorySelection;
                }
                throw new IllegalArgumentException("올바른 번호를 입력해주세요");
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }catch (InputMismatchException e) {
                System.err.println("숫자만 입력가능합니다");
                scanner.next();
            }
        }
    }

    private void printCategory() {
        int index = 1;
        // 카테고리 출력
        System.out.println("[ MAIN MENU ]\n");
        for (Menu menu : menus) {
            System.out.println(index++ + ". " + menu.getCategory());
        }
        System.out.println("0. 종료");
    }

    private void printSelectedItem(int categorySelection, int menuSelection) {
        String format = "%-1d. %-15s | W %.1f | %s\n";
        System.out.printf(
                format,
                menuSelection,
                menus.get(categorySelection - 1).getMenuItems().get(menuSelection - 1).getName(),
                menus.get(categorySelection - 1).getMenuItems().get(menuSelection - 1).getPrice() / 1000.0,
                menus.get(categorySelection - 1).getMenuItems().get(menuSelection - 1).getDescription() + "\n");
    }
}
