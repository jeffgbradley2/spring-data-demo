package me.lab.springdatademo.domain.customer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional(readOnly = true)
    public Customer findById(Long id){
        return customerRepository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
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
