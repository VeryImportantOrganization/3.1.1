package web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Customer;

import java.util.List;

@Repository
@Transactional
public class CustomersDaoImpl implements CustomersDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void addUser(Customer customer) {
        entityManager.persist(customer);
    }
    @Override
    public void editUser(Customer customer) {
        entityManager.merge(customer);
    }
    @Override
    public void removeUser(long id) {
        entityManager.remove(entityManager.find(Customer.class, id));
    }
    @Override
    public Customer getUserById(long id) {
        return entityManager.find(Customer.class, id);
    }
    @Override
    public List<Customer> getAllUsers() {
        return entityManager.createQuery("FROM Customer", Customer.class).getResultList();
    }
}
