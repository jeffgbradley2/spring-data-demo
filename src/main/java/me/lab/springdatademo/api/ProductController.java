package me.lab.springdatademo.api;

import me.lab.springdatademo.domain.product.Product;
import me.lab.springdatademo.domain.product.ProductMapper;
import me.lab.springdatademo.domain.product.ProductService;
import me.lab.springdatademo.dto.ProductDto;
import me.lab.springdatademo.domain.shared.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper mapper;

    @Autowired
    public ProductController(ProductService productService, ProductMapper mapper) {
        this.productService = productService;
        this.mapper = mapper;
    }

    @PostMapping()
    public ProductDto post(@RequestBody ProductDto productDto){
        Product product = mapper.fromDto(productDto);
        product = productService.save(product);
        return mapper.toDto(product);
    }

    @GetMapping("/{id}")
    public ProductDto get(@PathVariable("id") Long id){
        Product product = productService.findById(id);
        return mapper.toDto(product);
    }

    @GetMapping()
    public List<ProductDto> getBySearchCriteria(@RequestBody SearchCriteria request){
        List<Product> products = productService.findBySearchCriteria(request);
        return mapper.toDto(products);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        productService.delete(id);
    }
}
