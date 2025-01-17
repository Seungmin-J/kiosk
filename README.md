# 키오스크
원하는 메뉴를 담아 주문할 수 있는 키오스크<br>
## Introduction
사용자가 메뉴를 확인하고 원하는 메뉴를 장바구니에 담거나 취소할 수 있는, 
<br>간단하고 직관적인 사용자 친화적 키오스크 애플리케이션입니다
## Tech Stack
- **Language**:  
  ![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
- **Tools**:  
  ![Git](https://img.shields.io/badge/Git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
## Features
- 메뉴 선택 - 메뉴는 메인 메뉴와 오더 메뉴로 나뉩니다
- [MAIN MENU] <br>
  음식 메뉴를 선택할 시 해당 음식 카테고리의 하위 메뉴을 확인할 수 있습니다
- [ORDER MENU]  
  오더 메뉴는 `ORDERS`, `CANCEL`이 있습니다  

  **ORDER**:  
  - 장바구니에 담긴 메뉴를 주문  
    - 주문 시 할인율 적용  
  - 장바구니의 특정 메뉴를 제외

  **CANCEL**:  
  - 장바구니에 있는 모든 메뉴 비우기
## Installation
리포지토리 클론:
```bash
   git clone https://github.com/Seungmin-J/kiosk.git
```
## Usage
**App 실행**:
   - `Main.java`를 실행하세요.
   - 원하는 메뉴를 선택하세요:

     ### MAIN MENU:
     메뉴를 선택하면 해당 메뉴의 카테고리에 해당하는 하위 메뉴가 조회됩니다<br>
     조회된 메뉴를 선택하면 장바구니에 추가할 수 있습니다
     ### ORDER MENU:
     **ORDERS:** <br>
     장바구니의 모든 메뉴를 주문합니다.<br>
     주문 시 적용 가능한 할인율을 선택할 수 있습니다.<br>
     장바구니에서 특정 메뉴를 제거할 수 있습니다.<br><br>
     **CANCEL:** <br>
     장바구니를 초기화하여 모든 메뉴를 삭제합니다.

   - 프로그램을 종료하려면 첫 메뉴 선택 시 0 을 입력하세요

## Contact
- **Email**: [seungmin103@gmail.com](mailto:seungmin103@gmail.com)  
- **GitHub**: [Seungmin-J](https://github.com/Seungmin-J)  
