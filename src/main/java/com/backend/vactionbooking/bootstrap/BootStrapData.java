package com.backend.vactionbooking.bootstrap;

import com.backend.vactionbooking.dao.CustomerRepository;
import com.backend.vactionbooking.dao.DivisionRepository;
import com.backend.vactionbooking.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception{

        if(customerRepository.count() == 1) {

            Customer koda = new Customer();
            koda.setFirstName("Koda");
            koda.setLastName("Baby");
            koda.setAddress("1459 Clement dr");
            koda.setPhone("849-123-4567");
            koda.setPostal_code("96745");
            koda.setDivision(divisionRepository.getReferenceById(2L));
            customerRepository.save(koda);

            Customer ollie = new Customer();
            ollie.setFirstName("Ollie");
            ollie.setLastName("Aussie");
            ollie.setAddress("1234 GG St");
            ollie.setPhone("123-456-7891");
            ollie.setPostal_code("90999");
            ollie.setDivision(divisionRepository.getReferenceById(3L));
            customerRepository.save(ollie);

            Customer mercedes = new Customer();
            mercedes.setFirstName("Mercedes");
            mercedes.setLastName("Greg");
            mercedes.setAddress("6789 Cod dr");
            mercedes.setPhone("555-111-1111");
            mercedes.setPostal_code("88977");
            mercedes.setDivision(divisionRepository.getReferenceById(4L));
            customerRepository.save(mercedes);

            Customer mars = new Customer();
            mars.setFirstName("Mars");
            mars.setLastName("Doe");
            mars.setAddress("4567 Black ops dr");
            mars.setPhone("888-888-7777");
            mars.setPostal_code("111111");
            mars.setDivision(divisionRepository.getReferenceById(5L));
            customerRepository.save(mars);

            Customer pluto = new Customer();
            pluto.setFirstName("Pluto");
            pluto.setLastName("jupy");
            pluto.setAddress("1111 crazy planets st");
            pluto.setPhone("111-109-8098");
            pluto.setPostal_code("94532");
            pluto.setDivision(divisionRepository.getReferenceById(6L));
            customerRepository.save(pluto);

        }

    }
}
