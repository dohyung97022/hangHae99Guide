def cycle(i):
    tenth = int(i//10)
    oneth = int(i%10)
    return oneth*10 + int((tenth+oneth)%10)

input = int(input())
cycle_count = 1
next_input = cycle(input)

while input != next_input:
    cycle_count+=1
    next_input = cycle(next_input)

print(cycle_count)