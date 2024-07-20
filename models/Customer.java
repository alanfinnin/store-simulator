package models;

public class Customer {
    int id = 0;
    // todo should be private or consistent
    boolean hasShopped = false;
    boolean hasPaid = false;
    boolean inLine = false;
    int timeTaken = 0;

    public Customer(int id) {
        this.id = id;
    }
    public void performAction() {
        this.timeTaken += 5;
    }

    public void performShopOrWait() {
        if(!this.hasShopped) {
            this.timeTaken += 20;
            this.hasShopped = true;
        }
    }

    public void performPay() {
        this.timeTaken += 5;
        this.hasPaid = true;
    }

    public boolean hasShopped(){
        return this.hasShopped;
    }

    public int getTimeTaken() {
        return this.timeTaken;
    }

    public boolean hasPaid() {
        return this.hasPaid;
    }

    public void printState() {
        System.out.println(String.format("Customer %d has shopped %b and has paid %b", this.id, this.hasShopped, this.hasPaid));
    }
    public int getId() {
        return this.id;
    }
}
