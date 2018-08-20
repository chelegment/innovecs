package fun.other.innovecs.task.to.Account;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {
    private Long id;
    private String name;
    private BigDecimal available;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public synchronized boolean sent(BigDecimal amount){
        if(available.compareTo(amount) < 0){
            return false;
        } else {
            available = available.subtract(amount);
            return true;
        }
    }

    public synchronized void receive(BigDecimal amount){
        available = available.add(amount);
    }

    public double getAvailable() {
        return available.doubleValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(name, account.name) &&
                Objects.equals(available, account.available);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, available);
    }
}
