package ca.johnholloway.chap12.repositories;

import ca.johnholloway.chap12.models.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRespository {

    private final JdbcTemplate jdbc;
    public PurchaseRespository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    public void storePurchase(Purchase purchase){
        String sql = "INSERT INTO purchase (product, price) VALUES (?, ?)";
        jdbc.update(
                sql,
                purchase.getProduct(),
                purchase.getPrice());
    }

    public List<Purchase> finalAllPurchases(){
        String sql = "SELECT * from purchase";
        RowMapper<Purchase> purchaseRowMapper = (r,i) ->{
            Purchase rowObject = new Purchase();
            rowObject.setId(r.getInt("id"));
            rowObject.setProduct(r.getString("product"));
            rowObject.setPrice(r.getBigDecimal("price"));
            return rowObject;
        };

        return jdbc.query(sql, purchaseRowMapper);
    }
}

/*

Test the repo with Httpie via the following console commands:

To submit data:

$   http POST http://localhost:8080/purchase product="Spring Security in Action" price:=25.2
$   http POST http://localhost:8080/purchase product="Spring in Action" price=75.5
$   http POST http://localhost:8080/purchase product="Headfirst Design patterns" price=55.5


Retrieving with a get request will result in the following:

$   http http://localhost:8080/purchase

HTTP/1.1 200
Connection: keep-alive
Content-Type: application/json
Date: Fri, 03 May 2024 06:26:36 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

[
    {
        "id": 1,
        "price": 25.2,
        "product": "Spring Security in Action"
    },
    {
        "id": 2,
        "price": 75.5,
        "product": "Spring in Action"
    },
    {
        "id": 3,
        "price": 55.5,
        "product": "Headfirst Design patterns"
    }
]

 */