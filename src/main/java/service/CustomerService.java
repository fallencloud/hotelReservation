package service;

import model.Customer;

import java.util.*;

public class CustomerService {
    private static CustomerService customerInstance = null;
    Map<String, Customer> customers = new HashMap<>();

    private CustomerService() {}

    public static CustomerService getInstance() {
        if(customerInstance == null) {
            customerInstance = new CustomerService();
        }

        return customerInstance;
    }
    public void addCustomer(String email, String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName, email);
        customers.put(customer.getEmail(), customer);
    }

    // TODO: Implement getCustomer
    public Customer getCustomer(String customerEmail) {
        return customers.get(customerEmail);
    }

    /**
     * @return
     */
    public Collection<Customer> getAllCustomers() {
        return (Collection<Customer>) customers;
    }
}
