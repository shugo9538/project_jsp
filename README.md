# project_jsp

MVC

Model : 

  - UserVO, CategoryVO, ProductVO 작성완료
  - GuestService : 사용자의 데이터 접근 동작 관리
  - AdminSerice : 관리자의 데이터 접근 동작 관리
  - DAO : 데이터 베이스 접근 요청/응답(Enum Singleton형태로 작성) 
        
Controller :

  - GuestController : 사용자 접근 관리
  - AdminController : 관리자 접근 관리
      
View : 

      /guest
        - /account : 사용자 관리(회원가입, 로그인, 회원정보 수정, 회원탈퇴)
          - action : service 동작 후 성공 실패에 따라 redirection 방향 결정
          - page : 사용자에게 실제로 보여지는 페이지
          - css : style.css로 병항 예정
          - js : scripts.js 파일에서 정리 중 차후 추가 정리 예정
      
      /common
        - 공통 파일 전체(전체 css적용, header, footer 등 포함)
        - styleSettings.jsp, settings.jsp는 include용 파일(css 설정 및 태그 설정)
      
      /admin
        - /account : 로그인 세션 관리
        - /category : 카테고리 추가, 삭제 및 목록 확인 페이지


![image](https://user-images.githubusercontent.com/28711917/127891988-e1acc734-29dc-4aa2-800e-c24c131d92ea.png "쿠키(세션)에 대한 이미지")

그림1. 쿠키(세션)에 대한 이미지

request.getSession() : 서버와 사용자 간에 지정된(공유된) 자원의 데이터를 가지고 오는 것 ex) 사용자의 로그인 상태
request.getParameter(), request.getAttribute() : 일회성 요청에 대한 데이터를 가지고 오는 것 ex) 폼에 입력된 (회원가입에 필요한 정보, 로그인 정보)을 전달하기 위해 사용

session - 지속적으로 서버와 데이터를 공유하고 있는 자원 => 언제까지? context.xml에 Resource태그에 선언한 timeout시간동안 보유 혹은 invalidate()메서드와 같이 세션을 종료하는 메서드가 

REFERENCE
그림1. http://jun.hansung.ac.kr/SWP/PHP/PHP%20Sessions.html
