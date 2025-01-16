package kiosk.lv6.controller;

import kiosk.lv6.model.Cart;
import kiosk.lv6.model.FoodMenu;
import kiosk.lv6.model.Menu;
import kiosk.lv6.model.MenuItem;
import kiosk.lv6.view.MenuView;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class KioskController {

    Scanner scanner = new Scanner(System.in);
    private final List<Menu> menus;
    private final Cart cart  = new Cart();
    private boolean isCartEmpty = true;

    public KioskController(List<Menu> menus) {
        this.menus = menus;
    }

    public boolean isCartEmpty() {
        return isCartEmpty;
    }

    public Cart getCart() {
        return cart;
    }

    public void clearCart() {
        cart.getItemsInCart().clear();
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public MenuItem getSelectedItem(FoodMenu menu, int menuSelection) {
        if(menu.isMenuItemsEmpty());
        MenuView.printSelectedItem(menu.getMenuItems().get(menuSelection - 1));
        return menu.getMenuItems().get(menuSelection - 1);
    }

    public int getMenuItemSelection(FoodMenu menu) {
        System.out.println("메뉴를 선택하세요\n");
        MenuView.printMenuItems(menu);
        return scanner.nextInt();
    }

    public int getMenuSelection(List<Menu> menus) {
        int menuSelection;
        while (true) {
            System.out.print("카테고리를 선택하세요: ");
            try {
                menuSelection = scanner.nextInt();
                if (menuSelection > 0 && menuSelection <= menus.size()) {
                    return menuSelection;
                } else if (menuSelection == 0) {
                    throw new IllegalArgumentException("시스템을 종료합니다");
                } else {
                    System.out.println("올바른 번호를 입력해주세요");
                }
            } catch (InputMismatchException e) {
                System.err.println("숫자만 입력 가능합니다.\n");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return -1;
            }
        }
    }

    public void addToCart(MenuItem item) {
        if(!isCartEmpty) {
            setIsCartEmptyFalse();
        }
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소");
        int yesNo = scanner.nextInt();
        if (yesNo == 1) {
            cart.getItemsInCart().add(item);
        } else if (yesNo == 2) {
        } else {
            throw new IllegalArgumentException("보기중 입력해주세요");
        }
    }

    public void setIsCartEmptyTrue() {
        isCartEmpty = true;
    }
    public void setIsCartEmptyFalse() {
        isCartEmpty = false;
    }

    public boolean handleBackOption(int menuSelection) {
        if (menuSelection == 0) {
            System.out.println("뒤로 이동");
            return true;
        }
        return false;
    }

    public Menu getMenu(int categorySelection) {
        return getMenus().get(categorySelection - 1);
    }
}
