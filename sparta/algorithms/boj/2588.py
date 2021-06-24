num_1, num_2 = input().split()
num_1 = int(num_1)
num_2 = int(num_2)

# 마지막 자릿수
output_1 = num_1 * (num_2 % 10)
# 두번째 자릿수
output_2 = num_1 * int((num_2 / 10) % 10)
# 첫번재 자릿수
output_3 = num_1 * int((num_2 / 100) % 10)

print(output_1)
print(output_2)
print(output_3)
print(num_1 * num_2)