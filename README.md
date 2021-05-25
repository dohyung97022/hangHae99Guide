# hangHae99Guide
### 이 repository 는 :
항해 99 부트캠프를 진행하면서 배우고 느낀 점을 기록하는 공간입니다.   
항해 99를 고려하고 있으시거나 궁굼하시다면 도움이 되길 바랍니다.   
<br/>
## 목차
* #### 일간 기록   
* #### 공부   
    * 웹개발 좋합반 1주차
    * 웹개발 종합반 2주차
* #### 시스템   
    * 면접

<br/>

* ## 일간 기록
    * #### 21/5/22

<br/>

* ## 공부
    * ### 웹개발 종합반 1주차
      * #### 수업에서 제공된 내용
        * 기본적인 html, CSS, javascript 관련된 초초초 기초들을 배웁니다.
      * #### 느낀 점
        술자는 과거 프로젝트를 진행한 적이 있어 빠르게 넘어갔지만   
        1주차는 아마 코딩에 대한 지식이 전혀 없을 수 있는 초보분들을 고려한 내용으로 보입니다.   
        재미있는 점은 강의마다 숙제를 낸다는 점입니다.
      * #### 숙제
        * CSS와 html의 기초적 이해를 요구하는 숙제...   
          CSS를 전에 많이 사용하였지만 AWS 자격증을 준비하느라 다 휘발성 메모리가 되었나 봅니다. ㅋㅋ  
          기억이 새록새록 돌아오는 경험이였습니다.   
          [저의 정답](sparta/frontend/01_homework.html)   
        * ![](img/web_week_1_homework.PNG)
    
    * ### 웹개발 종합반 2주차
      * #### jQuery
        * #### 수업에서 제공된 내용   
          * `https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js`
          * `$('#idselector')`
          * `$('#idselector').hide`
          * `$('#idselector').show`
          * `$('#idselector').val()`
          * `$('#idselector').val("anyValue")`
          * `$('#idselector').text("anyText")`
          * `$('#idselector').css("cssAtribute")`
          * `let tmp_btn = <button>click</button>` `$('#idselector').append(tmp_btn)`
          * `$('#idselector').empty()`
        * #### 느낀 점
          제공된 [html template](sparta\frontend\02_article.html)에서 `$('selector')`를 통해 사용할 수 있는 기능들에 대하여 배웠습니다.   
          jQuery는 javascript의 코드를 간략하게 하기 위한 라이브러리입니다.   
          저는 react 부터 시작한 사람이라서   
          static website에 jQuery를 통한 웹 기능 구현에 익숙하지 않았습니다.   
          S3 같은 곳에 static website의 구현을 요구할 지도 모르는데   
          아무리 현업이 react 범벅?이 되어 있다고 하더라도 이러한 방법을 이해하는 것도 중요하다고 생각됩니다.   
          간편하고 저렴하고 빠른 방법이 될 수 있겠다는 생각이 들었습니다.
            
        * #### 퀴즈
            * Static website에서 버튼 클릭으로 인한 기능을 jQuery로 구현하는 퀴즈였습니다.
            * ![](img/web_week_2_quiz.PNG)
          
      * #### Ajax, JSON
        * #### 수업에서 제공된 내용
          * 특정 url에서 Get 받기
            ```
            $.ajax({ type: "GET", 
            url: "api.myapi.com",
            data: {},
            success: 
            function(response){
                console.log(response)
              }
            })
            ```
        * #### 느낀 점 
          Ajax는 jQuery에서 import되어 web response를 받는 라이브러리입니다.   
          저는 Ajax를 많이 들어본 적은 있었지만 직접적으로 사용해 본 적은 이번이 처음이였습니다.   
          React의 Axios framework를 사용하였지만 더 기본적인 라이브러리를 볼 수 있는 경험이였습니다.  
          다만 w3school은 ajax에서 XMLHttpRequest를 더 중심적으로 교육하는 것 같습니다.   
          API Hierarchy : jQuery.get/post > jQuery.ajax > XMLHttpRequest  
          참고 : [StackOverflow의 고인물들...](https://stackoverflow.com/questions/4657287/what-is-the-difference-between-xmlhttprequest-jquery-ajax-jquery-post-jquery)
        * #### 퀴즈
            [서울 미세먼지 API](http://openapi.seoul.go.kr:8088/6d4d776b466c656533356a4b4b5872/json/RealtimeCityAir/1/99)    
            [따릉이 API](http://spartacodingclub.shop/sparta_api/seoulbike)   
            [카와이한 고양이 API](https://api.thecatapi.com/v1/images/search)   
            위 API를 통하여 static website를 변동시키는 퀴즈였습니다.   
            [저의 정답](sparta/frontend/02_Ajax_quiz.html)   
            ![](img/web_week_2_quiz2.PNG)   
            아... 커여워....
          
      * #### 숙제
        * 1주차 때 만들었던 템플렛에 환율 정보를 추가하는 것이 숙제로 나왔습니다.   
        [저의 정답](sparta/frontend/02_homework.html)   
        ![](img/web_week_2_homework.PNG)
        
            
* ## 시스템
    * ### 면접
        * #### 면접 구성
            * 서류면접 -> 대면면접 -> 최종합격
        * #### 서류면접
            * 서류 면접은 직접 확인하시기 바랍니다.   
            제가 지원한 21년도 1분기와 다를 수 있습니다.
        * #### 대면면접
            * 면접의 내용은 코딩 중심적이지 않았습니다.  
            서류면접에 관련된 내용을 토대로 질문하며 추가적으로    
            끈기, 몰입, 노력, 성품에 대하여 물어보았습니다.   
            질문으로 받은 것을 예로 들면   
            '과거 끈기 있게 무엇을 끝까지 한 적이 있나요?'   
            '인간관계가 어려워지면 어떻게 하시나요?'   
            '프로그래머가 되기 위하여 어떠한 노력을 하셨나요?'   
            같은 질문이 있었습니다.   
            항해 99는 팀원들끼리 서비스를 직접 런칭하는 부트캠프라서   
            역량과 인간관계에 관련된 질문들로 구성한 것이 인상 깊었습니다.   
            선하고 성실하시다면 합격입니다. ㅋㅋ   
        * #### 최종합격
            * 최종 합격이 되었다는 카톡이 오고 결제를 완료하시면 이런 카톡이 옵니다.   
            카톡을 받은 이후 항해99 슬랙에 가입하라는 문자가 몇 일 이후에 왔습니다.
            * ![](img/최종합격.jpg)
