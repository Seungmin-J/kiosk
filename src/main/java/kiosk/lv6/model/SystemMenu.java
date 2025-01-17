package kiosk.lv6.model;

import kiosk.lv6.controller.KioskController;
import kiosk.lv6.view.CartView;

import java.util.List;
import java.util.Scanner;

public class SystemMenu extends Menu {
    Scanner scanner = new Scanner(System.in);

    public SystemMenu(Integer id, Category category) {
        super(id, category);
    }

    @Override
    public boolean processMenuSelection(KioskController controller) {
        List<MenuItem> menuItems = controller.getCart().getCartList();
        if (getCategory() == Category.ORDERS) {
            if (validateCartItems(menuItems)) return true;

            System.out.println("1. 주문하기     2. 물건 빼기");
            int selection = scanner.nextInt();
            scanner.nextLine();

            if(selection == 1) {
                return processOrder(controller);
            } else if (selection == 2) {
                return removeItemFromCart(controller);
            }
        } else if (getCategory() == Category.CANCEL) {
            validateCartItems(menuItems);
            controller.clearCart();
            System.out.println("장바구니 초기화");
            return true;
        }
        return true;
    }

    private boolean removeItemFromCart(KioskController controller) {
        System.out.println("빼고 싶은 아이템의 이름을 입력하세요");
        String name = scanner.nextLine();
        MenuItem menuItem = controller.getCart().getCartList()
                .stream()
                .filter(item -> item.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 아이템이 없습니다"));
        controller.getCart().getCartList().remove(menuItem);
        if(controller.getCart().getCartList().isEmpty()) {
            controller.setIsCartEmptyTrue();
        }
        return true;
    }

    private boolean processOrder(KioskController controller) {
        List<MenuItem> menuItems = controller.getCart().getCartList();
        validateCartItems(menuItems);
        int price = 0;
        for (MenuItem item : menuItems) {
            price += item.getPrice();
        }
        DiscountType discountType = getDiscountType();
        System.out.println("장바구니에 담긴 상품을 주문하시겠습니까?");
        CartView.printItemsInCart(controller);
        CartView.printPrice(price, discountType);

        order(controller);
        return true;
    }

    // 입력값 검증
    private boolean validateCartItems(List<MenuItem> menuItems) {
        if (menuItems.isEmpty()) {
            System.out.println("올바른 번호를 입력해주세요");
            return true;
        }
        return false;
    }

    private DiscountType getDiscountType() {
        DiscountType discountType;
        System.out.println("할인 정보를 입력해주세요.\n" +
                "1. 국가유공자 : 10% \n" +
                "2. 군인     :  5%\n" +
                "3. 학생     :  3%\n" +
                "4. 일반     :  0%");
        while (true) {
            int type = scanner.nextInt();
            switch (type) {
                case 1:
                    discountType = DiscountType.PNM;
                    return discountType;
                case 2:
                    discountType = DiscountType.SOLDIER;
                    return discountType;
                case 3:
                    discountType = DiscountType.STUDENT;
                    return discountType;
                case 4:
                    discountType = DiscountType.ORDINARY;
                    return discountType;
                default:
                    System.out.println("보기 중에 선택하세요");
                    break;
            }
        }
    }

    // 주문하면 카트가 clear
    private void order(KioskController controller) {
        System.out.println("1. 주문       2. 뒤로가기");
        int yesOrNo = scanner.nextInt();
        if (yesOrNo == 2) {
            // 사용자가 취소를 선택한 경우 메서드 종료
            System.out.println("메뉴판으로 돌아갑니다");
        }
        if (yesOrNo == 1) {
            System.out.println("구매완료");
            controller.clearCart();
        }
    }
}
