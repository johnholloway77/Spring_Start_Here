package ca.johnholloway.chap13.repositories.mappers;


import ca.johnholloway.chap13.models.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException{
            Account a = new Account();
            a.setId(resultSet.getInt("id"));
            a.setName(resultSet.getString("name"));
            a.setAmount(resultSet.getBigDecimal("amount"));
            return a;

    }

}
