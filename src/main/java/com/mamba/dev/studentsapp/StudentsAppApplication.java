package com.mamba.dev.studentsapp;

import com.mamba.dev.studentsapp.entities.Product;
import com.mamba.dev.studentsapp.repository.ProductRepository;
import com.sun.jdi.LongValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@SpringBootApplication
public class StudentsAppApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(StudentsAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        productRepository.save(new Product(null,"House",152000,2));
        productRepository.save(new Product(null,"APPT",58532,6));
        productRepository.save(new Product(null,"KITCHEN",47855,6));
        productRepository.save(new Product(null,"FLOOR",125488,3));

        List<Product> products= productRepository.findAll();
        products.forEach(p->{
            System.out.println("*******************");
            System.out.println(p.toString());
        });

        Product product = productRepository.findById(Long.valueOf(1)).get();
        System.out.println("************************");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println("**********************");
        List<Product> productList = productRepository.findByNameContains("C");
        productList.forEach(p->{
            System.out.println(p);
        });
        System.out.println("----------------------");
        System.out.println("----------------------");

        List<Product> productbyletter = productRepository.search("C");
        productList.forEach(p->{
            System.out.println(p);
        });

    }
}
