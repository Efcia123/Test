import org.apache.commons.lang3.StringUtils;

/**
 * Created by Efcia on 2014-05-01.
 */
public class Money {
    private int amount;
    private String currency;

    public Money(int amount, String currency) {
        if (amount < 0) {
            throw new IllegalArgumentException("Illegal amount: " + amount);
        }

        if (StringUtils.isBlank(currency)) {
            throw new IllegalArgumentException("Illegal currency: " + currency);
        }

        this.amount = amount;
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Money)) {
            return false;
        }

        Money money = (Money) o;

        if (amount != money.amount) {
            return false;
        }
        if (!currency.equals(money.currency)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = amount;
        result = 31 * result + currency.hashCode();
        return result;
    }
}
