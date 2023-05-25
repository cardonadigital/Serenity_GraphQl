package co.com.sofka.models;

import java.util.ArrayList;

public class Customer {
    private Integer id;
    private String lastName;
    private String firstName;
    private ArrayList<Integer> orders = new ArrayList<>();

    public Customer(Integer id, String name, String lastname, Integer order1, Integer order2) {
        this.id = id;
        this.firstName = name;
        this.lastName = lastname;
        orders.add(1);
        orders.add(2);
    }

    public Customer(int id, String name) {
        this.id = id;
        this.firstName = name;
    }

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }


    public ArrayList<Integer> getOrders() {
        return orders;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setOrders(ArrayList<Integer> orders) {
        this.orders = orders;
    }
}
