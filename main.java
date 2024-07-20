import java.util.ArrayList;
import java.util.List;

import models.Customer;
import models.Store;
import services.RunnerService;

public class main {   
    public static void main(String[] args) {

        int numberOfTills = 5;
        int numberOfCustomers = 50000;
        List<Customer> customers = new ArrayList<>();
        for(int i = 0; i < numberOfCustomers; i++) {
            customers.add(new Customer(i));
        }


        Store store = new Store(false, numberOfTills);

        RunnerService.multiRuns(10000, store, customers);      
    }
}