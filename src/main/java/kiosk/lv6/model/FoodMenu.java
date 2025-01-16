package kiosk.lv6.model;

import kiosk.lv6.controller.KioskController;
import kiosk.lv6.factory.MenuFactory;

import java.util.ArrayList;
import java.util.List;

public class FoodMenu extends Menu {
    private final List<MenuItem> menuItems;
    private final Category category;
    private final Integer id;

    public FoodMenu(Integer id, Category category) {
        super(id, category);
        this.category = category;
        this.id = id;
        this.menuItems = init(category);
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public boolean handleMenuAction(KioskController controller) {
        int menuSelection = controller.getMenuItemSelection(this);
        if (controller.handleBackOption(menuSelection)) return true;

        // 메뉴 아이템 선택
        MenuItem selectedItem = controller.getSelectedItem(this, menuSelection);
        // 선택한 아이템 장바구니에 추가
        while (true) {
            try {
                controller.addToCart(selectedItem);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    public boolean isMenuItemsEmpty() {
        if (this.getMenuItems().isEmpty()) {
            System.out.println("메뉴가 없습니다");
            return true;
        }
        return false;
    }

    private List<MenuItem> init(Category category) {
        List<MenuItem> list = new ArrayList<>();
        switch (category) {
            case BURGERS:
                return MenuFactory.createBurgerItems();
            case DRINKS:
                return MenuFactory.createDrinkItems();
            case DESSERTS:
                return MenuFactory.createDessertItems();
        }
        return list;
    }
}
