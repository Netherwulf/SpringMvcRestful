package netherwulf.springfamework.bootstrap;

import netherwulf.springfamework.domain.Category;
import netherwulf.springfamework.domain.Customer;
import netherwulf.springfamework.repositories.CategoryRepository;
import netherwulf.springfamework.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategories();
        loadCustomers();
    }

    public void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("Categories loaded = " + categoryRepository.count());
    }

    private void loadCustomers() {
        Customer joeNewman = new Customer();
        joeNewman.setFirstName("Joe");
        joeNewman.setLastName("Newman");

        Customer michaelLachappele = new Customer();
        michaelLachappele.setFirstName("Michael");
        michaelLachappele.setLastName("Lachappele");

        Customer davidWinter = new Customer();
        davidWinter.setFirstName("David");
        davidWinter.setLastName("Winter");

        Customer anneHine = new Customer();
        anneHine.setFirstName("Anne");
        anneHine.setLastName("Hine");

        Customer aliceEastman = new Customer();
        aliceEastman.setFirstName("Alice");
        aliceEastman.setLastName("Eastman");

        customerRepository.save(joeNewman);
        customerRepository.save(michaelLachappele);
        customerRepository.save(davidWinter);
        customerRepository.save(anneHine);
        customerRepository.save(aliceEastman);

        System.out.println("Customers loaded = " + customerRepository.count());
    }
}
