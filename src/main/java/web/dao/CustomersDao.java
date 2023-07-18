package web.dao;

import web.model.Customer;

import java.util.List;

public interface CustomersDao {

    void addUser(Customer customer);
    void editUser(Customer customer);
    void removeUser(long id);
    Customer getUserById(long id);
    List<Customer> getAllUsers();
}
