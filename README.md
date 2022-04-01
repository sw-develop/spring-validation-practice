### 목적
Thymeleaf와 Spring Boot를 사용해 화면과 서버에서의 Validation 검사 처리 방식에 대해 이해한다.   
Spring Boot의 REST API를 사용해 서버에서의 Validation 검사 처리 방식에 대해 이해한다.

Controller에서 입력값 및 Request Body에 대한 유효성 검사를 수행하도록 한다. (Service로 넘기지 않음)

### 1) Thymeleaf + Spring Boot에서의 Validation 검사
플로우: 화면에서 검사(input 유효성 검사) -> 서버에서 검사(단순 검사, 구체적 검사)

화면에서 검사 - bootstrap의 html5 validation을 사용하는 것   
단순 검사 - @NotEmpty, @NotNull 등의 기존 구현된 어노테이션 사용   
구체적 검사 - ConstraintValidator 인터페이스를 사용해 Custom Validation 구현

### 2) Spring Boot REST API에서의 Validation 검사
플로우: 서버에서 검사(단순 검사, 구체적 검사) → 1)과 동일함

추가 확인할 점
- 서버사이드 렌더링 방식이 아닌 Response Body로 반환함
- Validation을 통해 반환되는 오류 메시지가 통일됨


### *추가해볼 것   

[중요도: 중] 로그인/회원가입 기능 넣어볼까..?   
[중요도: 상] 비밀번호 DB에 저장시 암호화된 형태로 저장하기(AttributeConverter 인터페이스 사용)   
[중요도: 중] Slf4j를 사용한 Logback으로 로그 남기기 연습   

---

### A. Thymeleaf + Spring Boot에서의 Validation 검사

### A-1) 단순 검사 - DTO에서의 @NotEmpty, @NotNull 등의 어노테이션 사용

### A-2) 구체적 검사 - ConstraintValidator 인터페이스 구현하는 것 (Custom Validation)