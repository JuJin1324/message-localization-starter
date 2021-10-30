# message-localization-starter
## 실행 환경
> OS: macOS  
> JAVA: 11
## 준비
> DB: H2 Database  
> DB 소스 위치(application.yml 의 spring.datasource.url 에서 수정): ~/Documents/dev/h2/message-localization

## 테스트 방법
### API
1. test/java/mvc.practice.starter/UserControllerTest 실행  
2. Application 실행 후 `http://localhost:8080/api/users/9999999?locale=ko` 및
`http://localhost:8080/api/users/9999999?locale=en` 실행

### HTML Form
1. Application 실행
2. 브라우저에 `http://localhost:8080/users/add` 실행
3. 브라우저 설정에서 검색창에 언어 -> 영어(미국) 옆에 ... 세로 버튼 클릭 후 가장 위로 이동 후 2. 에서 실행한 페이지 새로고침

## 흐름
### API
> 1.웹 브라우저에 `http://localhost:8080/api/users/9999999?locale=ko` 를 통해서 요청시 
> `controllers.api 패키지의 UserApiController` 에서 `UserService` 호출을 한다.  
> 2.`UserService`에서 `NotFoundResourceException` 이 발생하여 `ExceptionController`의 `handleNotFoundException` 메서드가 호출된다.

### Form
> resources/templates/message/addForm.html 에서 타임리프 문법인 `#{메시지 소스 메시지}` 를 통해서 messages.properties 에 정의한 code 를   
> 기술하면 된다. ex: `#{label.user.name}`

## 소스 코드
> resources/i18n 아래 messages_xx.properties 파일들: 메시지 정의  
> exceptions 패키지: message_xx.properties 파일에 정의한 메시지 코드 사용   
> controllers 패키지의 ExceptionController: message 코드와 맵핑된 내용 사용   
> config 패키지의 MessageConfig: properties 파일 대신에 yaml 파일 사용하도록 설정    
> application.yml
> ```yaml
> spring:
>     messages:
>     basename: i18n/messages,i18n/exceptions   # resources 에 message.properties 파일 위치
> ```

## 주의
### yml / properties
> 처음에 [SpringBoot2로 Rest api 만들기(7) – MessageSource를 이용한 Exception 처리](https://daddyprogrammer.org/post/499/springboot2-exception-handling-with-messagesource/)
> 사이트를 참고해서 messageSource 파일을 yaml 로 사용하여 구현하였다. 하지만 yaml 파일 구현에 있어   
> 단점이 yaml 파일을 messageSource 로 1개 밖에 지정할 수 없다는 것이다.  
> application.yml 에서 `spring.message.basename` 에 콤마로 구분하여 2개 이상의 messageSource 파일을 등록하려하면 프로그램이 정상동작하지 않았다.  
> .properties 파일의 경우 2개 이상의 messageSource 등록이 가능하였음으로 .properties 파일로 변경하였다.  

### localization
> .properties 파일 사용시에 default properties 즉 _ko 나 _en 이 붙지 않은 파일(ex: messages.properties) 이 존재하지 않으면 오류 발생하였다.  
> 현재 프로젝트에서는 한국어의 경우 디폴트 파일에 저장하였으며 영어의 경우 postfix 로 _en 붙인 파일(ex: message_en.properties)에 저장하였다. 

