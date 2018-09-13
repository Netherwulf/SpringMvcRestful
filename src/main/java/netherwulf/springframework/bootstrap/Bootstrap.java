package netherwulf.springframework.bootstrap;

import netherwulf.springframework.domain.Category;
import netherwulf.springframework.domain.Customer;
import netherwulf.springframework.domain.Vendor;
import netherwulf.springframework.repositories.CategoryRepository;
import netherwulf.springframework.repositories.CustomerRepository;
import netherwulf.springframework.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;
    private VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategories();
        loadCustomers();
        loadVendors();
    }

    private void loadCategories() {
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

    private void loadVendors() {

        Vendor andrewGolara = new Vendor();
        andrewGolara.setName("Andrew Golara");

        Vendor tommyCash = new Vendor();
        tommyCash.setName("Tommy Cash");

        Vendor butterBean = new Vendor();
        butterBean.setName("Butter Bean");

        Vendor sellIt = new Vendor();
        sellIt.setName("Sell IT");

        Vendor orangeShop = new Vendor();
        orangeShop.setName("Orange Shop");

        vendorRepository.save(andrewGolara);
        vendorRepository.save(tommyCash);
        vendorRepository.save(butterBean);
        vendorRepository.save(sellIt);
        vendorRepository.save(orangeShop);

        System.out.println("Vendors loaded = " + vendorRepository.count());
    }
}
