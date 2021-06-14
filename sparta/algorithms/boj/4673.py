# 1부터 10000까지 생성자에 넣어 결과를 셀프 넘버에서 제한다.
LEN = 10001
is_self_num = [True]*LEN

def get_next(i):
    sum = i
    while(1):
        sum+= int(i%10)
        if i/10 > 1:
            i = i/10
        else :
            break
    return sum

for i in range(1,LEN):
    index = get_next(i)
    if (index < LEN):
        is_self_num[index] = False

for index, i in enumerate(is_self_num):
    if i == True:
        print(index)


# for enumerate를 왜우자!


# 다른 사람의 코드
natural_num = set(range(1,10001))
generated_num = set()
for i in range(1,10001):
    for j in str(i):
        i += int(j)
    generated_num.add(i)

self_num = sorted(natural_num-generated_num)
for i in self_num:
    print(i)

# str으로 생각하여 나의 /10 이나 %10을 생각할 필요 없다.