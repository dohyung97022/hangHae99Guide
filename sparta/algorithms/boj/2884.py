time = input().split()
timeMinites = int(time[0])*60 + int(time[1])
timeMinites = timeMinites - 45
if timeMinites < 0:
    timeMinites += 1440
print(f'{int(timeMinites/60)} {int(timeMinites%60)}')