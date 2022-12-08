REST-api basics

Business requirements:
1. Develop web service for Gift Certificates system with the following entities (many-to-many): gift_certificates (id, name, description, price, duration, create_date, last_update_date), tags (id, name).
2. The system should expose REST APIs to perform the following operations:
- CRUD operations for GiftCertificate. If new tags are passed during creation/modification – they should be created in the DB. For update operation - update only fields, that pass in request, others should not be updated. Batch insert is out of scope.
- CRD operations for Tag.
- Get certificates with tags (all params are optional and can be used in conjunction): by tag name (ONE tag), search by part of name/description (can be implemented, using DB function call), sort by date or by name ASC/DESC (extra task: implement ability to apply both sort type at the same time).

Application requirements:
1. JDK version: 8 – use Streams, java.time.*, etc. where it is possible. (the JDK version can be increased in agreement with the mentor)
2. Application packages root: com.epam.esm
3. Any widely-used connection pool could be used.
4. JDBC / Spring JDBC Template should be used for data access.
5. Use transactions where it’s necessary.
6. Build tool: Maven/Gradle, latest version. Multi-module project.
7. Web server: Apache Tomcat/Jetty.
8. Application container: Spring IoC. Spring Framework, the latest version.
9. Database: PostgreSQL/MySQL, latest version.
10. Testing: JUnit 5.+, Mockito.
11. Service layer should be covered with unit tests not less than 80%.
12. Repository layer should be tested using integration tests with an in-memory embedded database (all operations with certificates).
