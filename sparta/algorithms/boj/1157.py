str_input = input()
str_input = str_input.upper()

# 1. 맵에다가 각 값을 'M' : 10(나온 횟수) 저장하면서 
# 2. 맵에다가 +를 하며 나온 횟수를 받는다.
# 3. 만일 나온 횟수가 현제 최고 기록과 같다면 ?를 출력한다.

count_map = {}
cur_max_char = '?'
cur_max_count = 0
for char in str_input:
    if char in count_map:
        count_map[char] += 1
    else: 
        count_map[char] = 1
    if cur_max_count < count_map[char]:
        cur_max_char = char
        cur_max_count = count_map[char]
    elif cur_max_count == count_map[char]:
        cur_max_char = '?'


print (cur_max_char)