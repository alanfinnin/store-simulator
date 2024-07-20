package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import models.Customer;
import models.Store;
import services.RunnerService;

public class RunnerServiceTests {
    @Test  
    public void runWithOneCustomerOneTill() {
        int numberOfTills = 1;
        int numberOfCustomers = 1;
        List<Customer> customers = new ArrayList<>();
        for(int i = 0; i < numberOfCustomers; i++) {
            customers.add(new Customer(i));
        }

        Store store = new Store(false, numberOfTills);  

        assertEquals("1 customers took average 30 time with max 30 id: 0", RunnerService.run(store, customers));
    }

    @Test  
    public void runWithEvenCustomersAndTills() {
        int numberOfTills = 5;
        int numberOfCustomers = 5;
        List<Customer> customers = new ArrayList<>();
        for(int i = 0; i < numberOfCustomers; i++) {
            customers.add(new Customer(i));
        }

        Store store = new Store(false, numberOfTills);  

        assertEquals("5 customers took average 30 time with max 30 id: 0", RunnerService.run(store, customers));
    }

    @Test  
    public void runWithUnevenCustomersAndTills() {
        int numberOfTills = 5;
        int numberOfCustomers = 6;
        List<Customer> customers = new ArrayList<>();
        for(int i = 0; i < numberOfCustomers; i++) {
            customers.add(new Customer(i));
        }

        Store store = new Store(false, numberOfTills);  

        assertEquals("6 customers took average 30 time with max 35 id: 0", RunnerService.run(store, customers));
    }
}
