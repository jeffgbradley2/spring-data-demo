package me.lab.springdatademo.api.controller;

import me.lab.springdatademo.domain.customer.Customer;
import me.lab.springdatademo.domain.customer.CustomerMapper;
import me.lab.springdatademo.domain.customer.CustomerService;
import me.lab.springdatademo.api.dto.CustomerDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @GetMapping
    public List<CustomerDto> getAll(){
        List<Customer> customers = customerService.findAll();
        return customerMapper.toDto(customers);
    }

    @GetMapping("/{id}")
    public CustomerDto get(@PathVariable("id") Long id){
        Customer customer = customerService.findById(id);
        return customerMapper.toDto(customer);
    }

    @PostMapping
    public CustomerDto post(@RequestBody CustomerDto customerDto){
        Customer customer = customerMapper.fromDto(customerDto);
        customer = customerService.save(customer);
        return customerMapper.toDto(customer);
    }
}
