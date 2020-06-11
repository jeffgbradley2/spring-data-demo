package me.lab.springdatademo.domain.product;

import me.lab.springdatademo.domain.shared.SearchCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product findById(Long id){
        return productRepository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    public List<Product> findBySearchCriteria(SearchCriteria criteria){
        return productRepository.findAll(new ProductSpecification(criteria));
    }

    @Transactional(readOnly = true)
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
