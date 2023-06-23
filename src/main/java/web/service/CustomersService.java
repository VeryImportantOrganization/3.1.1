package web.service;

import web.model.Customer;

import java.util.List;

public interface CustomersService {
    public void addUser(Customer customer);
    public void editUser(Customer customer);
    public void removeUser(long id);
    public Customer getUserById(long id);
    public List<Customer> usersList();
}
