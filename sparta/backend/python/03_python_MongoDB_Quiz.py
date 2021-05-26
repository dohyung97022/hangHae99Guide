from pymongo import MongoClient
import re
import requests

# 영화를 가져온다.
movieArr = []
for x in ['1', '9', '17', '25', '33']:
    reqHtml = requests.get(
        'https://m.search.naver.com/p/csearch/content/qapirender.nhn?_callback=___MovieAPIforPList_key_68_pkid_nexearch_where_' + x
        + '_start_8_display_s1_dsc_so_%ED%98%84%EC%9E%AC%EC%83%81%EC%98%81%EC%98%81%ED%99%94_q&key=MovieAPIforPList&pkid=68&where=nexearch&start=' + x
        + '&display=8&so=s1.dsc&q=%ED%98%84%EC%9E%AC%EC%83%81%EC%98%81%EC%98%81%ED%99%94')
    a = re.findall('this_text _text\\\\">([^<]+)', reqHtml.text)
    print(a)
    movieArr = a + movieArr

# pymongo를 setup한다.
client = MongoClient('localhost', 27017)
db = client.dbMovies

# array 형식을 dictionary 형식으로 바꾼다.
movieDicArr = []
for movieName in movieArr:
    movieDicArr.append({'name': movieName})

# 저장한다.
db.users.insert_many(movieDicArr)

