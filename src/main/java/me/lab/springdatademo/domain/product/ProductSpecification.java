package me.lab.springdatademo.domain.product;

import me.lab.springdatademo.domain.shared.SearchCriteria;
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

        switch(criteria.getOperation()){
            case EQUALS : return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());
            case NOT_EQUALS: return criteriaBuilder.notEqual(root.get(criteria.getKey()), criteria.getValue());
            case GREATER_THAN: return criteriaBuilder.greaterThan(root.get(criteria.getKey()), criteria.getValue());
            case LESS_THAN: return criteriaBuilder.lessThan(root.get(criteria.getKey()), criteria.getValue());
            case LIKE: return criteriaBuilder.like(root.get(criteria.getKey()), criteria.getValue());
            default: return null;
        }
    }
}
