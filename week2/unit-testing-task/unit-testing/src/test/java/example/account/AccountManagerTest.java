package example.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountManagerTest {

    @Test
    void givenCustomerWithSufficientBalance_whenWithdraw_thenSucceed() {
        // Arrange
        AccountManager am = new AccountManagerImpl();
        Customer c = new Customer();
        c.setBalance(1000);

        // Act
        String result = am.withdraw(c, 500);

        // Assert
        Assertions.assertEquals("success", result);
        Assertions.assertEquals(500, c.getBalance());
    }

    @Test
    void givenCustomerWithInsufficientBalanceAndNoCredit_whenWithdraw_thenFailDueToInsufficientBalance() {
        AccountManager am = new AccountManagerImpl();
        Customer c = new Customer();
        c.setBalance(1000);
        String result = am.withdraw(c, 1500);

        Assertions.assertEquals("insufficient account balance", result);
    }
    @Test
    void givenCustomerWithInsufficientBalanceAndCreditExceededAndNotVip_whenWithdraw_thenSucceed() {
        AccountManager am = new AccountManagerImpl();
        Customer c = new Customer();
        c.setBalance(1000);
        c.setCreditAllowed(true);
        String result = am.withdraw(c, 1500);

        Assertions.assertEquals("success", result);
    }

    @Test
    void givenCustomerWithInsufficientBalanceButWithinCreditLimitAndNotVip_whenWithdraw_thenFailDueToMaxCreditExceeded() {
        AccountManager am = new AccountManagerImpl();
        Customer c = new Customer();
        c.setBalance(1000);
        c.setCreditAllowed(true);
        c.setVip(false);
        String result = am.withdraw(c, 2500);

        Assertions.assertEquals("maximum credit exceeded", result);
    }

    @Test
    void givenCustomerWithInsufficientBalanceButWithinCreditLimitAndVip_whenWithdraw_thenSucceed() {
        AccountManager am = new AccountManagerImpl();
        Customer c = new Customer();
        c.setBalance(1000);
        c.setCreditAllowed(true);
        c.setVip(true);
        String result = am.withdraw(c, 2500);

        Assertions.assertEquals("success", result);
    }

    @Test
    void givenCustomer_whenDeposit_thenBalanceIncreases() {
        AccountManager am = new AccountManagerImpl();
        Customer c = new Customer();
        c.setBalance(1000);
        am.deposit(c, 1000);

        Assertions.assertEquals(2000, c.getBalance());
    }




}
