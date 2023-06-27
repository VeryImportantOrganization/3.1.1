package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Customer;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CustomersDaoImpl implements CustomersDao {

    @PersistenceContext //для автоматического связывания менеджера сущностей с бином
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
    public List<Customer> usersList() {
        return entityManager.createQuery("FROM Customer", Customer.class).getResultList();
    }
}
