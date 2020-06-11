package me.lab.springdatademo.domain.customer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findById(Long id){
        return customerRepository.findById(id).orElseThrow();
    }

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Customer getProxy(Long id){
        return customerRepository.getOne(id);
    }

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }
}
