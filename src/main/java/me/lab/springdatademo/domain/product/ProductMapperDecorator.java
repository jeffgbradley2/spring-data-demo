package me.lab.springdatademo.domain.product;

import me.lab.springdatademo.domain.customer.Customer;
import me.lab.springdatademo.domain.customer.CustomerService;
import me.lab.springdatademo.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class ProductMapperDecorator implements ProductMapper{

    @Autowired
    @Qualifier("delegate")
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
