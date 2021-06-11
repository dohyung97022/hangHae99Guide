shop_menus = ["만두", "떡볶이", "오뎅", "사이다", "콜라"]
shop_orders = ["오뎅", "콜라", "만두"]


def is_available_to_order(menus, orders):
    # 이 부분을 채워보세요!
    possible = True
    for order in orders:
        possible = order_binary(menus, order)
        if not possible:
            break
    return possible

def order_binary(menus, order):
    # 1. 한글을 정렬한다.
    menus.sort()
    # 2. 2분 탐색한다.
    # 2-0. 길이가 없다면 false를 반환
    if len(menus) == 0:
        return False
    # 2-1. 중앙값 지정
    mid = int(len(menus)/2)
    # 2-2. 중앙값과 일치한다면 true
    if menus[mid] == order:
        return True
    # 2-2. 중앙값보다 작다면 0~중앙값-1
    elif order < menus[mid]:
        return order_binary(menus[0:mid], order)
    # 2-3. 중앙값보다 크다면 중앙값+1~len(menus)
    elif order > menus[mid]:
        return order_binary(menus[mid+1:len(menus)], order)

result = is_available_to_order(shop_menus, shop_orders)
print(result)