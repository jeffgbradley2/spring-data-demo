package me.lab.springdatademo.domain.customer;

import me.lab.springdatademo.domain.product.ProductMapper;
import me.lab.springdatademo.dto.CustomerDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring",
        uses = { ProductMapper.class })
@DecoratedWith(CustomerMapperDecorator.class)
public interface CustomerMapper {
    CustomerDto toDto(Customer customer);
    List<CustomerDto> toDto(List<Customer> customers);
    Customer fromDto(CustomerDto customerDto);
}
