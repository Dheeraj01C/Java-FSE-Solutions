package Week1.Module_1;

/*
 * Exercise 11: Implementing Dependency Injection
 * Scenario:
 * Customer Management System using Constructor Injection.
 */

// Repository Interface
interface CustomerRepository {

    // Find customer by ID
    String findCustomerById(int id);
}

// Concrete Repository
class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public String findCustomerById(int id) {
        return "Customer ID: " + id + ", Name: Dheeraj";
    }
}

// Service Class
class CustomerService {

    private CustomerRepository repository;

    // Constructor Injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    // Get Customer
    public void getCustomer(int id) {
        System.out.println(repository.findCustomerById(id));
    }
}

// Main Class
public class Excercise_11 {

    public static void main(String[] args) {

        // Create Repository
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject Repository into Service
        CustomerService service = new CustomerService(repository);

        // Find Customer
        service.getCustomer(101);
    }
}