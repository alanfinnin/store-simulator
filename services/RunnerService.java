package services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.Customer;
import models.Store;

public class RunnerService {
    private static void tickCustomers(List<Customer> customers) {
        for(int i = 0; i < customers.size(); i++) {
            if(!customers.get(i).hasPaid()){
                customers.get(i).performAction();
            }
        }
    }

    public static String run(Store store, List<Customer> customers) {
        int iterations = 0;

        store.addCustomers(customers);
        while(store.getCustomers().size() != 0) {
            iterations++;

            tickCustomers(customers);

            store.getCustomers().forEach(customer -> customer.performShopOrWait());

            store.performTillsActions();
        }

        //System.out.println(String.format("Simulation took %d iteration(s)", iterations));

        //store.printState();

        return CustomerService.aggregateCustomerInfo(customers);
    }

    public static void multiRuns(int numberOfRuns, Store store, List<Customer> customers) {
        float averageCounter = 0;
        float average = 0;
        List<String> outputs = new ArrayList<>();
        for(int i = 0; i < numberOfRuns; i++) {

            Date startTime = new Date();
            outputs.add(RunnerService.run(store,customers));
            Date endTime = new Date();
            averageCounter += (endTime.getTime() - startTime.getTime());             
        }

        average = averageCounter/numberOfRuns;
        System.out.println(String.format("Time taken: %f for %d runs", averageCounter, numberOfRuns));
        System.out.println(String.format("Average time taken: %f", average));
        //for(String output: outputs) {
        //    System.out.println(output);
        //}
    }
}
