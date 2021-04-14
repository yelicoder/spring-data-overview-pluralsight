# spring-data-overview-pluralsight
Pluralsight course material for Spring Data Overview

### Module 2
* Create a data testing class
  - Annotate with @RunWith(SpringRunner.class) and @DataJpaTest
  - @DataJpaTest call for less resource than @SpringBootTest
  - Annotate each method with @Test
  - use AssertJ assertThat
* AssertJ dependency
```
<groupId>org.assertj</groupId>
<artifactId>assertj-core</artifactId>
```
### Module 3
* Repository Pattern: A persistence ignorant data access abstraction
* Spring Data Commons: Repository, CRUD Repository, PagingAndSortingRepository, Module Specific Implementations
* public interface Respository <T, ID>
*   - T: Type of entity to persist
*   - ID: ID type for the entity
```
public interface CrudRepository<T, ID> extends Repository<T, ID> {
    <S extends T> S save(S var1); //creating or updating
    Optional<T> findById(ID var1); //reading
    void delete(T var1); //deleting
...//more
```
#### Derived Queries
* query generated by parsing the method name
* No boilerplate
* generated for us
* executed for us
* mapped for us
* easy learning curve: no need to write a native query
* easy to swap implementations

#### PagingAndSortingRepository
```
public interface PagingAndSortingRepository<T, ID> extends CrudRepository<T, ID> {
    Iterable<T> findAll(Sort var1);

    Page<T> findAll(Pageable var1);
}
```
#### Switching to MongoDB
* Change dependency from Jpa to mongodb
```
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-data-mongodb</artifactId>
```
* Change dependency from H2 to embedded mongodb
```
<groupId>de.flapdoodle.embed</groupId>
<artifactId>de.flapdoodle.embed.mongo</artifactId>
<scope>test</scope>
```
* javax.persistence package does not exist
  - remove javax.persistence annotation and change all id fields to String
* Change Repository ID type to String
* Change from @DataJpaTest to @DataMongoTest
#### Custom Repository implementation
* Create an interface and its implementation
* Entity repository implements the interface

### Module 4
#### @Transactional
* Spring Core, not just Spring Data

