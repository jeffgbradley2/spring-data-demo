package me.lab.springdatademo.domain.product;

import me.lab.springdatademo.api.dto.ProductDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
@DecoratedWith(ProductMapperDecorator.class)
public interface ProductMapper {
    @Mapping(target = "customerId", source = "customer.id")
    ProductDto toDto(Product product);
    List<ProductDto> toDto(List<Product> products);
    Product fromDto(ProductDto productDto);
}
