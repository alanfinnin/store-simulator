package services;
import java.util.List;

import models.Customer;

public class CustomerService {
    public static String aggregateCustomerInfo(List<Customer> customers) {
        int maxTime = customers.get(0).getTimeTaken();
        int maxTimeIndex = customers.get(0).getId();
        int timeCount = 0;
        for(Customer customer: customers) {
            if(customer.getTimeTaken() > maxTime) { 
                maxTime = customer.getTimeTaken();
                maxTimeIndex = customer.getId();
            }
            timeCount += customer.getTimeTaken();
        }
        return String.format("%d customers took average %d time with max %d id: %d", customers.size(), timeCount/customers.size(), maxTime, maxTimeIndex);
    }
}
