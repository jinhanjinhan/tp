package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Student's payment status in the address book.
 * Guarantees: immutable;
 */
public class Payment {

    public static final String MESSAGE_CONSTRAINTS = "Payment (marked by 'pay/') should be an negative, zero, or "
            + "positive integer \n'$' is not required \n Leading zero are allowed but not recommended";
    public static final String VALIDATION_REGEX = "^-?[0-9]\\d*|0$\n";
    public final String balance;

    /**
     * Constructs an {@code Payment}.
     *
     * @param balance Boolean for payment status
     */
    public Payment(String balance) {
        requireNonNull(balance);
        this.balance = balance;
    }

    /**
     * Returns true if a given string is a valid payment status (either true or false).
     */
    public static Boolean isValidPayment(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return "Balance: " + balance;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Payment)) {
            return false;
        }

        Payment otherPayment = (Payment) other;
        return balance.equals(otherPayment.balance);
    }

    @Override
    public int hashCode() {
        return balance.hashCode();
    }

}

