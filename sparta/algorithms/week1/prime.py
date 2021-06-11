input = 20


def find_prime_list_under_number(number):
    # 저의 정답
    # 에스토스테네스의 체
    # 1. 한개씩 숫자를 지나간다.
    # 2. 한개씩 숫자를 지나가며 소수를 찾는다.
    # 3. 소수를 찾았다면 그 소수의 배수를 지운다.
    # 4. 1을 반복한다.

    arr = []
    for i in range(3, input + 1): # range(int1, int2) 이거 까먹음...
        arr.append(i)

    for i in arr:
        eraser = i
        while eraser <= 20:
            eraser += eraser
            if eraser in arr:
                arr.remove(eraser)

    return arr


result = find_prime_list_under_number(input)
print(result)