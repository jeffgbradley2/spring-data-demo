package me.lab.springdatademo.domain.product;

import me.lab.springdatademo.dto.SearchCriteria;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product findById(Long id){
        return productRepository.findById(id).orElseThrow();
    }

    @Transactional
    public List<Product> findBySearchCriteria(SearchCriteria criteria){
        return productRepository.findAll(new ProductSpecification(criteria));
    }

    @Transactional
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    @Transactional
    public Product save(Product product){
        return productRepository.save(product);
    }

    @Transactional
    public void delete(Long id){
        productRepository.deleteById(id);
    }
}
