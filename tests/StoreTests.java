package tests;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import models.Customer;
import models.Store;

public class StoreTests {
    @Test  
    public void performTillsActionsWithOneCustomer() {
        Store store = new Store(false, 1);
        Customer customer = new Customer(0);

        List<Customer> customers = new ArrayList<>();
        customers.add(customer);

        store.addCustomers(customers);
        store.performTillsActions();

        assertEquals(store.getCustomers().size(), 0);  
    }  

    @Test  
    public void performTillsActionsWithMoreThanOneCustomer() {
        Store store = new Store(false, 1);
        Customer customer = new Customer(0);
        Customer customer2 = new Customer(1);
        Customer customer3 = new Customer(2);

        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        customers.add(customer2);
        customers.add(customer3);

        store.addCustomers(customers);
        store.performTillsActions();

        assertEquals(store.getCustomers().size(), 2);  
    }  

    @Test  
    public void performTillsActionsWithMoreThanOneCustomerAndTills() {
        Store store = new Store(false, 3);
        Customer customer = new Customer(0);
        Customer customer2 = new Customer(1);
        Customer customer3 = new Customer(2);

        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        customers.add(customer2);
        customers.add(customer3);

        store.addCustomers(customers);
        store.performTillsActions();

        assertEquals(store.getCustomers().size(), 0);  
    }  

    @Test  
    public void performTillsActionsWithThreeCustomersAndTwoTills() {
        Store store = new Store(false, 2);
        Customer customer = new Customer(0);
        Customer customer2 = new Customer(1);
        Customer customer3 = new Customer(2);

        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        customers.add(customer2);
        customers.add(customer3);

        store.addCustomers(customers);
        store.performTillsActions();

        assertEquals(store.getCustomers().size(), 1);  
    } 

    @Test  
    public void performTillsActionsWithOneCustomerAndThreeTills() {
        Store store = new Store(false, 3);
        Customer customer = new Customer(0);

        List<Customer> customers = new ArrayList<>();
        customers.add(customer);

        store.addCustomers(customers);
        store.performTillsActions();

        assertEquals(store.getCustomers().size(), 0);  
    } 
    
}
