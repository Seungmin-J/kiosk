package kiosk.lv6.model;

import kiosk.lv6.controller.KioskController;

public abstract class Menu {
    private final Category category;
    private final Integer id;

    public Menu(Integer id, Category category) {
        this.category = category;
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public Integer getId() {
        return id;
    }

    public abstract boolean processMenuSelection(KioskController controller);
}
