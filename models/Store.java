package models;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private boolean DEBUG = true;
    // todo make configurable
    List<Customer> customers = new ArrayList<>();
    List<Till> tills;

    public Store(boolean DEBUG, int numberOfTills) {
        this.DEBUG = DEBUG;

        this.tills = new ArrayList<>();
        for(int i = 0; i < numberOfTills; i++) {
            this.tills.add(buildTill(i + 1, numberOfTills));
        }
    }

    public void addCustomers(List<Customer> customers) {
        for (int i = 0; i < customers.size(); i++) {
            this.customers.add(customers.get(i));
        }
    }

    private Till buildTill(int id, int customersPerTill){
        return new Till(id, customersPerTill);
    }

    public List<Customer> getCustomers() {
        return this.customers;
    }

    public void performTillsActions() {
        if(this.DEBUG) System.out.println("TILL FILLING");
        
        int numberOfCustomers;
        int minCustomers;
        int minIndex;
        for(final Customer customer: this.customers) {
            if(customer.inLine) break;
            minCustomers = Integer.MAX_VALUE;
            minIndex = -1;

            if(this.DEBUG) System.out.println(String.format("cid:%d\t", customer.id));
            for(int i = 0; i < this.tills.size(); i++) {
                numberOfCustomers = this.tills.get(i).getCustomers().size();
                if(this.DEBUG) System.out.println(String.format("\ttid:%d=%d", this.tills.get(i).id, this.tills.get(i).getCustomers().size()));
                if(this.tills.get(i).hasTillSpace()) {
                    if (numberOfCustomers < minCustomers) {
                        minCustomers = numberOfCustomers;
                        minIndex = i;
                    }                    
                }
    
            }
            if(minIndex != -1) this.tills.get(minIndex).addCustomer(customer);
        }

        for(final Till till: this.tills) {
            till.act();
        }
        
        if(this.DEBUG) System.out.println("PAYMENT");
        for(int i = this.customers.size()-1; i >= 0; i--) {
            if(this.DEBUG) System.out.println(String.format("cid:%d inline:%b paid:%b", this.customers.get(i).id, this.customers.get(i).inLine, this.customers.get(i).hasPaid));
            if(this.customers.get(i).hasPaid()) {
                this.customers.remove(i);
            }
        }
        if(this.DEBUG) System.out.println();
    }

    public void printState() {
        System.out.println(String.format("Store has %d tills", this.tills.size()));
        System.out.println(String.format("Store has %d customers", this.customers.size()));

        this.tills.forEach(till -> System.out.println(String.format("Till %d has %d customers", till.id, till.getCustomers().size())));
    }

}
