package web.dao;

import web.model.Customer;

import java.util.List;

public interface CustomersDao {

    public void addUser(Customer customer);
    public void editUser(Customer customer);
    public void removeUser(long id);
    public Customer getUserById(long id);
    public List<Customer> usersList();
}
