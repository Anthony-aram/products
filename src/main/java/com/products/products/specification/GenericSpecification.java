package com.products.products.specification;

import com.products.products.specification.utils.SearchCriteria;
import com.products.products.specification.utils.SearchOperation;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

/**
 * Spécification générique
 * @param <T> Type de l'entité
 */
public class GenericSpecification<T> implements Specification<T> {

    private List<SearchCriteria> searchCriteriaList;

    /**
     * Constructeur
     */
    public GenericSpecification() {
        this.searchCriteriaList = new ArrayList<>();
    }

    /**
     * Ajouter un critère de recherche
     * @param searchCriteria Critère de recherche
     */
    public void add(SearchCriteria searchCriteria) {
        searchCriteriaList.add(searchCriteria);
    }

    /**
     * Convertir la spécification en prédicat
     * @param root Root
     * @param query CriteriaQuery
     * @param criteriaBuilder CriteriaBuilder
     * @return Prédicat
     */
    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        for (SearchCriteria searchCriteria : searchCriteriaList) {
            if(searchCriteria.getOperation().equals(SearchOperation.EQUAL)) {
                predicates.add(criteriaBuilder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue()));
            }
            else if(searchCriteria.getOperation().equals(SearchOperation.NOT_EQUAL)) {
                predicates.add(criteriaBuilder.greaterThan(root.get(searchCriteria.getKey()), searchCriteria.getValue().toString()));
            }
            else if(searchCriteria.getOperation().equals(SearchOperation.GREATER_THAN)) {
                predicates.add(criteriaBuilder.greaterThan(root.get(searchCriteria.getKey()), searchCriteria.getValue().toString()));
            }
            else if(searchCriteria.getOperation().equals(SearchOperation.GREATER_THAN_EQUAL)) {
                predicates.add(criteriaBuilder.greaterThan(root.get(searchCriteria.getKey()), searchCriteria.getValue().toString()));
            }
            else if(searchCriteria.getOperation().equals(SearchOperation.LESS_THAN)) {
                predicates.add(criteriaBuilder.lessThan(root.get(searchCriteria.getKey()), searchCriteria.getValue().toString()));
            }
            else if(searchCriteria.getOperation().equals(SearchOperation.LESS_THAN_EQUAL)) {
                predicates.add(criteriaBuilder.lessThan(root.get(searchCriteria.getKey()), searchCriteria.getValue().toString()));
            }
            else if(searchCriteria.getOperation().equals(SearchOperation.LIKE)) {
                predicates.add(criteriaBuilder.like(root.get(searchCriteria.getKey()), "%" + searchCriteria.getValue() + "%"));
            }
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
