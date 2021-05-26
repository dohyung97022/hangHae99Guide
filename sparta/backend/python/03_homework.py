import re
import requests

# 영화를 가져온다.
headers = {'User-Agent': ('Mozilla/5.0 (Windows NT 10.0;Win64; x64)\AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98\Safari/537.36')}
reqHtml = requests.get('https://www.genie.co.kr/chart/top200?ditc=D&ymd=20210526&hh=13&rtm=Y&pg=1', headers=headers)
titles = re.findall('class="albumtitle[^>]+>([^<]+)<', reqHtml.text)
artist = re.findall('class="artist[^>]+>([^<]+)<', reqHtml.text)
print(titles)
print(artist)
