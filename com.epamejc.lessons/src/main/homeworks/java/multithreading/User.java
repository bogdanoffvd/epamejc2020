package homeworks.java.multithreading;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

@Data
public class User extends Person {

    private static int count = 0;
    private int id;
    private BigDecimal cash;
    private final String name;
    private BigDecimal salary;

    public User(@NotNull String name, double cash, double salary) {

        id = ++count;
        this.name = name;
        this.cash = new BigDecimal(cash);
        this.salary = new BigDecimal(salary);

    }

    public BigDecimal getBankAccountDetails () {

        return Bank.getInstance().getUserAccountDetails(this);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}