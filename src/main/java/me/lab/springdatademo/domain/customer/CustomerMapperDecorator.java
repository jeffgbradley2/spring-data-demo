package me.lab.springdatademo.domain.customer;

import me.lab.springdatademo.api.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CustomerMapperDecorator implements CustomerMapper {

    @Autowired
    private CustomerMapper delegate;

    @Override
    public Customer fromDto(CustomerDto customerDto) {

        Customer customer = delegate.fromDto(customerDto);

        customer.getProducts().forEach(product ->
                product.setCustomer(customer));

        return customer;
    }
}
