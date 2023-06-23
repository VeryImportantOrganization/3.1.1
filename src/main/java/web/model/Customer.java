package web.model;


import javax.persistence.*;

/*
Перейдем к созданию рабочего web-приложения. Все ключевые моменты были рассмотрены в предыдущих задачах.
Теперь вам требуется их сопоставить и связать в один проект.
Используя наработки по mvc и hibernate соберите CRUD-приложение.
Задание:
Написать CRUD-приложение. Использовать Spring MVC + Hibernate.
Должен быть класс {{User }}с произвольными полями (id, name и т.п.).
В приложении должна быть страница, на которую выводятся все юзеры с возможностью добавлять, удалять и
изменять юзера.
Конфигурация Spring через {{JavaConfig }}и аннотации, по аналогии с предыдущими проектами. Без использования
xml. Без Spring Boot.
Внесите изменения в конфигурацию для работы с базой данных. Вместо SessionFactory должен использоваться
EntityManager.
 */

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private String email;
    @Column
    private int age;

    public Customer() {
    }

    public Customer(String firstname, String lastname, String email, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
