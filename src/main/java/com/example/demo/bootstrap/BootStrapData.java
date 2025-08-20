package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.dao.CartRepository;
import com.example.demo.entities.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;
    private final CartRepository cartRepository;

    @Override
    public void run(String... args) throws Exception {

        // clear dependent data first
        cartRepository.deleteAllInBatch();
        customerRepository.deleteAllInBatch();

        if (customerRepository.count() == 0) {
            Customer customer1 = new Customer();
            customer1.setFirstName("Kelly");
            customer1.setLastName("White");
            customer1.setPostal_code("30077");
            customer1.setAddress("111 Victoria Street");
            customer1.setPhone("(334)889-9901");
            customer1.setDivision(divisionRepository.findAll().get(1));
            customer1.setCreate_date(new Date());
            customer1.setLast_update(new Date());

            Customer customer2 = new Customer();
            customer2.setFirstName("Rose");
            customer2.setLastName("Lane");
            customer2.setPostal_code("96795");
            customer2.setAddress("222 Saint Court");
            customer2.setPhone("(678)990-2222");
            customer2.setDivision(divisionRepository.findAll().get(2));
            customer2.setCreate_date(new Date());
            customer2.setLast_update(new Date());

            Customer customer3 = new Customer();
            customer3.setFirstName("Joyce");
            customer3.setLastName("Key");
            customer3.setPostal_code("30080");
            customer3.setAddress("3255 Alameda");
            customer3.setPhone("(666)897-4490");
            customer3.setDivision(divisionRepository.findAll().get(3));
            customer3.setCreate_date(new Date());
            customer3.setLast_update(new Date());

            Customer customer4 = new Customer();
            customer4.setFirstName("Mary");
            customer4.setLastName("Lane");
            customer4.setPostal_code("71190");
            customer4.setAddress("4896 Poly Street");
            customer4.setPhone("(545)888-4698");
            customer4.setDivision(divisionRepository.findAll().get(4));
            customer4.setCreate_date(new Date());
            customer4.setLast_update(new Date());

            Customer customer5 = new Customer();
            customer5.setFirstName("Richard");
            customer5.setLastName("Smith");
            customer5.setPostal_code("73510");
            customer5.setAddress("9089 Willy Road");
            customer5.setPhone("(885)566-5555");
            customer5.setDivision(divisionRepository.findAll().get(5));
            customer5.setCreate_date(new Date());
            customer5.setLast_update(new Date());

            customerRepository.save(customer1);
            customerRepository.save(customer2);
            customerRepository.save(customer3);
            customerRepository.save(customer4);
            customerRepository.save(customer5);

            System.out.println("Sample customers added!");
        } else {
            System.out.println("Sample customers already exist!");
        }
    }
}
