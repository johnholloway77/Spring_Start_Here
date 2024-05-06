package ca.johnholloway.chap14.repositories;

import ca.johnholloway.chap14.models.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

//by using the CrudRepository interface, Spring Data will provide the methods for simple Create, Read, Update & delete operations
public interface AccountRepository extends CrudRepository<Account, Long> {

    /*
    We can also create custom queries by having Spring Data interpret the methods' names
    eg:
    List<Account> findAccountsByName(String name);

    This can be limited if the query needs to be more complex, objects change, etc.
     */


    //We can use the @Query annotation to provide the required SQL if Spring Data cannot infer it from the method name alone
    //Note: this method requires the exact name to return a list of accounts. Eg will return for a parameter of "John Doe" but not "John". Not as useful for search
    @Query ("SELECT * FROM account WHERE name = :name")
    List<Account> findAccountsByName(String name);


    List<Account> findAccountsByNameContainingIgnoreCase(String name);

    //if you are using the SQL commands UPDATE, INSERT, or DELETE it is best to use the @Modifying attribute with @Query
    @Modifying
    @Query("UPDATE account SET amount = :amount WHERE id = :id")
    void changeAmount(long id, BigDecimal amount);

    @Query("Select * FROM account where name = 'John Doe'")
    Account callJohn();

}
