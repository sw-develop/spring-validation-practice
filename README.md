### 목적
Thymeleaf와 Spring Boot를 사용해 화면과 서버에서의 Validation 검사 처리 방식에 대해 이해한다.
Spring Boot의 REST API를 사용해 서버에서의 Validation 검사 처리 방식에 대해 이해한다.

Controller에서 유효성 검사를 처리하도록 한다. (Service로 넘기지 않음)

### 1) Thymeleaf + Spring Boot에서의 Validation 검사
플로우: 화면에서 검사(input 유효성 검사) -> 서버에서 검사(단순 검사, 구체적 검사)

화면에서 검사 - bootstrap의 html5 validation을 사용하는 것

단순 검사 - DTO에서의 @NotEmpty, @NotNull 같은 것

구체적 검사 - ConstraintValidator 인터페이스 구현하는 것

### 2) Spring Boot REST API에서의 Validation 검사
플로우: 서버에서 검사(단순 검사, 구체적 검사) --> 1)과 동일함

차이점 - 서버사이드 렌더링 방식이 아닌 Response Body로 반환함   



*추가해볼 것   

[중요도: 상] 비밀번호 DB에 저장시 암호화된 형태로 저장하기(AttributeConverter 인터페이스 사용)   
[중요도: 중] Slf4j를 사용한 Logback으로 로그 남기기 연습   

---

### A. Thymeleaf + Spring Boot에서의 Validation 검사
### A-1) 단순 검사 - DTO에서의 @NotEmpty, @NotNull 같은 것
*form
```HTML
<form id="userSignUpForm" name="userSignUpForm" action="#" th:action="@{/user/sign-up}" th:object="${userSignUpReqDto}" method="POST">
```
- th:action: form 태그 사용 시 해당 경로로 요청을 보낼 때 사용한다.
- th:object: form submit을 할 때, form의 데이터가 th:object에 설정해준 객체로 받아진다.

```HTMl
<tr>
    <td>닉네임:</td>
    <td><input type="text" th:field="*{nickName}" /></td>
    <td th:if="${#fields.hasErrors('nickName')}" th:errors="*{nickName}">닉네임</td>
</tr>
```
- th:field: 필드들을 매핑해주는 역할을 한다. th:object에 설정한 객체의 내부 필드와 매칭해준다.
- th:errors: 해당 필드의 error가 있는 경우 error message를 출력한다.

참고)   
https://velog.io/@max9106/Thymeleaf-%EC%9E%90%EC%A3%BC-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94-%EB%AC%B8%EB%B2%95

