package etech.admin.rest.find;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class QuerySpecification<T> implements Specification<T> {

    private List<SearchCriteria> criteriaList;

    public QuerySpecification() {
    }

    public QuerySpecification(List<SearchCriteria> criteriaList) {
        this.criteriaList = criteriaList;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        List<Predicate> predicates = new ArrayList<Predicate>();
        criteriaList.forEach(criteria -> {
            if (criteria.getOperation().equalsIgnoreCase(">")) {
                predicates.add(
                        builder.greaterThanOrEqualTo(root.<String>get(criteria.getKey()), criteria.getValue().toString())
                );
            } else if (criteria.getOperation().equalsIgnoreCase("<")) {
                predicates.add(
                        builder.lessThanOrEqualTo(root.<String>get(criteria.getKey()), criteria.getValue().toString())
                );
            } else if (criteria.getOperation().equalsIgnoreCase("=")) {
                predicates.add(
                        builder.equal(root.get(criteria.getKey()), criteria.getValue())
                );
            } else if (criteria.getOperation().equalsIgnoreCase("LIKE")) {
                if (root.get(criteria.getKey()).getJavaType() == String.class) {
                    predicates.add(
                            builder.like(root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%")
                    );
                }
            }
        });
        return (!predicates.isEmpty() ? builder.and(predicates.toArray(new Predicate[predicates.size()])) : null);
    }

    public List<SearchCriteria> getCriteriaList() {
        return criteriaList;
    }

    public void setCriteriaList(List<SearchCriteria> criteriaList) {
        this.criteriaList = criteriaList;
    }
}

