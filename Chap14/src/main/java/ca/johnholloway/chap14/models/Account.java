package ca.johnholloway.chap14.models;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class Account {

    @Id //id is the primary key, thus we use the "@Id" attribute
    private long id;

    private String name;
    private BigDecimal amount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
