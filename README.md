# mc.java.sts.jpa

Java Persistence API (JPA)를 활용 / Oracle Cloud 데이터베이스와의 상호작용 실습<br/>
CRUD(Create, Read, Update, Delete) 구현을 통해 JPA의 기본 개념 이해 및 적용<br/>

-   **Java Version**: 17
-   **IDE**: IntelliJ IDEA
-   **Framework**: Spring Boot
-   **JPA Provider**: Hibernate
-   **Database**: Oracle Cloud Database
-   **Build Tool**: Maven

#

-   **엔티티 생성**: JPA를 통해 엔티티 클래스를 정의, 데이터베이스 테이블과 매핑
-   **CRUD 기능**: JPA Repository를 사용하여 기본적인 CRUD 작업
-   **REST API**: Spring Boot를 사용하여 RESTful API를 구현, JPA로 Oracle Cloud와 연동
-   **API 테스트**: Postman을 활용한 GET, POST(body:json 형식) 요청

#

### Oracle Cloud 데이터베이스 연결 설정

application.properties 파일에 Oracle Cloud 데이터베이스 연결 정보 추가

```properties
spring.datasource.url=jdbc:oracle:thin:@<host>:<port>:<service_name>
spring.datasource.username=<username>
spring.datasource.password=<password>
```
