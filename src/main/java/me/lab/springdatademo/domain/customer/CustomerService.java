package me.lab.springdatademo.domain.customer;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public Customer findById(Long id){
        return customerRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    @Transactional
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    @Transactional
    public Customer getProxy(Long id){
        return customerRepository.getOne(id);
    }
}
