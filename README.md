# message-localization-starter
## 실행 환경
> OS: macOS  
> JAVA: 11  
## 준비
> DB: H2 Database  
> DB 소스 위치(application.yml의 spring.datasource.url 에서 수정): ~/Documents/dev/h2/message-localization  

## 테스트 방법
1. test/java/mvc.practice.starter/UserControllerTest 실행  
2. Application 실행 후 `http://localhost:8080/users/9999999?locale=ko` 및 `http://localhost:8080/users/9999999?locale=en` 실행

