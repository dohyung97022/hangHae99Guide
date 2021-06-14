# 학생의 점수들을 다 더하고 평균을 구한다.
# (평균<점수) 학생 수/전체 학생 수를 구한다.

# 이거 외우자. 

# 5 50 70 80 100 받는 법
# list(map(int, input().split()))

# 반올림하여 소수점 3째 자리까지 받기
# print(f'{float_var:.3f}')

test_case =int(input())
for x in range(test_case):
    input_list = list(map(int, input().split()))
    student_num = input_list[0]
    student_scores = input_list[1:]

    student_sum = 0
    for score in student_scores:
        student_sum+=score
    student_avr = int(student_sum/student_num)

    student_above_avr_num = 0
    for score in student_scores:
        if score > student_avr:
            student_above_avr_num+=1
    print(f'{student_above_avr_num/student_num*100:.3f}%')
    