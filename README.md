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
