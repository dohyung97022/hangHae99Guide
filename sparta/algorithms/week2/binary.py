finding_target = 16
finding_numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]

def is_existing_target_number_binary(target, array):
    # 1. 중간값의 인덱스를 정한다.
    # 2. 중간 값과 일치하면 반환
    # 3. 중간값보다 작으면 0 ~ 중간 인덱스-1,
    # 4. 크면 중간 인덱스+1 ~ 마지막 인덱스
    # 주의 : 사이즈가 1이라는 것을 확인 해야 할까? 아니면 스텝 2가 해결을 할까?
    print(array)
    # 주의
    if len(array) == 0:
        return False
    # 1
    mid = int(len(array)/2)
    # 2
    if array[mid] == target:
        return True
    # 3
    elif array[mid] > target:
        return is_existing_target_number_binary(target, array[0:mid])
    # 4
    elif array[mid] < target:
        return is_existing_target_number_binary(target, array[mid+1:len(array)])
    # 재귀적

    return False


result = is_existing_target_number_binary(finding_target, finding_numbers)
print(result)