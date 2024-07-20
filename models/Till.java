package models;
import java.util.ArrayList;
import java.util.List;

public class Till {
    private int maxCustomers = 1;
    public int id = 1;
    private List<Customer> customers;
    Till(int id, int customersPerTill) {
        this.id = id;
        this.maxCustomers = customersPerTill;
        this.customers = new ArrayList<Customer>();
    }

    public boolean hasTillSpace(){
        return this.customers.size() < this.maxCustomers;
    }

    public void addCustomer(Customer customer) {
        customer.inLine = true;
        this.customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return this.customers;
    }

    public void act() {
        if(this.customers.size() == 0 ) return;
        this.customers.get(this.customers.size()-1).performPay();
        this.customers.remove(this.customers.size()-1);
    }
}
