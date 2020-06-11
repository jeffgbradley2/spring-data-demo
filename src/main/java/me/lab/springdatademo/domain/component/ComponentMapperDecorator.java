package me.lab.springdatademo.domain.component;

import me.lab.springdatademo.api.dto.ComponentDto;
import me.lab.springdatademo.domain.product.Product;
import me.lab.springdatademo.domain.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ComponentMapperDecorator implements ComponentMapper {

    @Autowired
    private ComponentMapper delegate;

    @Autowired
    private ProductService productService;

    @Override
    public Component fromDto(ComponentDto componentDto) {

        Component component = delegate.fromDto(componentDto);

        if(componentDto.getProductId() != null){
            Product product = productService.getProxy(componentDto.getProductId());
            component.setProduct(product);
        }

        return component;
    }
}
