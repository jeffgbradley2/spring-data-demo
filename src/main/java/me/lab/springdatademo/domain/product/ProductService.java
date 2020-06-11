package me.lab.springdatademo.domain.product;

import me.lab.springdatademo.domain.shared.SearchCriteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findById(Long id){
        return productRepository.findById(id).orElseThrow();
    }

    public List<Product> findBySearchCriteria(SearchCriteria criteria){
        return productRepository.findAll(new ProductSpecification(criteria));
    }

    public Product getProxy(Long id){
        return productRepository.getOne(id);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }
}
