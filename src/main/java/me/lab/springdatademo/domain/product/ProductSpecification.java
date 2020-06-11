package me.lab.springdatademo.domain.product;

import me.lab.springdatademo.dto.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ProductSpecification implements Specification<Product> {

    private final SearchCriteria criteria;

    public ProductSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if(criteria.getOperation().equalsIgnoreCase("EQUALS")) {
            return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());
        }
        if(criteria.getOperation().equalsIgnoreCase("GREATER_THAN")) {
            return criteriaBuilder.greaterThan(root.get(criteria.getKey()), criteria.getValue());
        }
        if(criteria.getOperation().equalsIgnoreCase("LESS_THAN")) {
            return criteriaBuilder.lessThan(root.get(criteria.getKey()), criteria.getValue());
        }
        if(criteria.getOperation().equalsIgnoreCase("LIKE")) {
            return criteriaBuilder.like(root.get(criteria.getKey()), criteria.getValue());
        }
        return null;
    }
}
