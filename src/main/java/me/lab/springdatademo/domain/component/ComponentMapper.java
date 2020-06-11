package me.lab.springdatademo.domain.component;

import me.lab.springdatademo.api.dto.ComponentDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
@DecoratedWith(ComponentMapperDecorator.class)
public interface ComponentMapper {
    @Mapping(target = "productId", source = "product.id")
    ComponentDto toDto(Component component);
    Component fromDto(ComponentDto componentDto);
}
