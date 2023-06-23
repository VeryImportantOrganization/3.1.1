package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.CustomersDao;
import web.model.Customer;

import java.util.List;

@Service
@Transactional
public class CustomersServiceImpl implements CustomersService {

    private final CustomersDao customersDao;

    @Autowired
    public CustomersServiceImpl(CustomersDao customersDao) {
        this.customersDao = customersDao;
    }

    @Override
    public void addUser(Customer customer) {
        customersDao.addUser(customer);
    }

    @Override
    public void editUser(Customer customer) {
        customersDao.editUser(customer);
    }

    @Override
    public void removeUser(long id) {
        customersDao.removeUser(id);
    }

    @Override
    public Customer getUserById(long id) {
        return this.customersDao.getUserById(id);
    }

    @Override
    public List<Customer> usersList() {
        return this.customersDao.usersList();
    }
}
