
# 1.라이브러리 불러오기
import requests
from bs4 import BeautifulSoup as bs
import pandas as pd

# 2.제목, 내용 리스트 선언
title = []
content = []

# 3.for문을 이용해 검색어 입력후 원하는 페이지에 접근, 정보 추출 후 리스트에 담기
search = input("검색할 키워드를 입력해주세요:")

for page_num in range(1):
    # range를 이용하면 0부터 인덱스가 시작되므로 page_num에 1을 더해준 url을 이용
    #url = f'https://smartstore.naver.com/compuzone/category/ALL?st=RECENT&free=false&dt=IMAGE&page={page_num+1}&size=40'
    url = f'https://search.naver.com/search.naver?where=influencer&sm=tab_jum&query='+ search
    
    # html 정보 받아와서 파싱
    response = requests.get(url)
    soup = bs(response.text , 'html.parser')

    # css selector로 페이지 내의 원하는 정보 가져오기
    html_title = soup.select('div.keyword_box_wrap.api_ani_send.type_color > div.detail_box > div.dsc_area > a.name_link._foryou_trigger')
    html_content = soup.select('a > p.dsc')


    # 텍스트만 추출
    for i in html_title:
        title.append(i.get_text())
        
    for i in html_content:
        content.append(i.get_text())


# 4.zip 모듈을 이용해서 list를 묶어주기        
list_sum = list(zip(title, content))


# 5.데이터프레임의 첫행에 들어갈 컬럼명
col = ['제목','내용']

# 6.pandas 데이터 프레임 형태로 가공
df = pd.DataFrame(list_sum, columns=col)

# 7.엑셀에 저장
df.to_excel(search + '.xlsx')

