package me.lab.springdatademo.domain.product;

import me.lab.springdatademo.domain.customer.Customer;
import me.lab.springdatademo.domain.customer.CustomerService;
import me.lab.springdatademo.api.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ProductMapperDecorator implements ProductMapper{

    @Autowired
    private ProductMapper delegate;

    @Autowired
    private CustomerService customerService;

    @Override
    public Product fromDto(ProductDto productDto) {

        Product product = delegate.fromDto(productDto);

        if(productDto.getCustomerId() != null){
            Customer customer = customerService.getProxy(productDto.getCustomerId());
            product.setCustomer(customer);
        }

        return product;
    }
}
