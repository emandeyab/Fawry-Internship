package example.store;

import example.account.AccountManager;
import example.account.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class StoreV2Test {


    @Test
    void givenProductOutOfStock_whenBuy_thenThrowOutOfStockException() {
        AccountManager accountManager = mock(AccountManager.class);
        when(accountManager.withdraw(any(), anyInt())).thenReturn("success");
        Product product = new Product();
        Customer customer = new Customer();
        product.setQuantity(0);
        Store store = new StoreImpl(accountManager);


        Assertions.assertThrows(RuntimeException.class, () -> store.buy(product, customer));

    }
    @Test
    void givenInsufficientBalance_whenBuy_thenThrowPaymentFailureException() {
        AccountManager accountManager = mock(AccountManager.class);
        when(accountManager.withdraw(any(), anyInt())).thenReturn("failure");
        Product product = new Product();
        Customer customer = new Customer();
        product.setQuantity(5);
        product.setPrice(100);
        customer.setBalance(50);
        Store store = new StoreImpl(accountManager);

        Assertions.assertThrows(RuntimeException.class, () -> store.buy(product, customer));
    }

    @Test
    void givenProductInStockAndSufficientBalance_whenBuy_thenDecreaseQuantity() {
        AccountManager accountManager = mock(AccountManager.class);
        when(accountManager.withdraw(any(), anyInt())).thenReturn("success");
        Product product = new Product();
        Customer customer = new Customer();
        product.setQuantity(5);
        Store store = new StoreImpl(accountManager);
        store.buy(product, customer);

        Assertions.assertEquals(4, product.getQuantity());

    }



}
