# message-localization-starter
## 실행 환경
> OS: macOS  
> JAVA: 11
## 준비
> DB: H2 Database  
> DB 소스 위치(application.yml의 spring.datasource.url 에서 수정): ~/Documents/dev/h2/message-localization

## 테스트 방법
### API
1. test/java/mvc.practice.starter/UserControllerTest 실행  
2. Application 실행 후 `http://localhost:8080/api/users/9999999?locale=ko` 및 `http://localhost:8080/api/users/9999999?locale=en` 실행

### HTML Form
1. Application 실행
2. 브라우저에 `http://localhost:8080/users/add` 실행
3. 브라우저 설정에서 검색창에 언어 -> 영어(미국) 옆에 ... 세로 버튼 클릭 후 가장 위로 이동 후 2. 에서 실행한 페이지 새로고침
