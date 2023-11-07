package com.unispace.lms.repository.impl;

import com.unispace.lms.model.Student;
import com.unispace.lms.repository.CustomStudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CustomStudentRepositoryImpl implements CustomStudentRepository {

  @PersistenceContext private EntityManager em;

  @Override
  public Page<Student> findAllByOwnerUserId(
      String searchQuery, Integer ownerUserId, Pageable pageable) {
    CriteriaBuilder builder = em.getCriteriaBuilder();
    CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
    countQuery.select(builder.count(countQuery.from(Student.class)));
    Long count = em.createQuery(countQuery).getSingleResult();

    CriteriaQuery<Student> query = builder.createQuery(Student.class);
    Root<Student> root = query.from(Student.class);

    Predicate hasOwnerId = builder.equal(root.get("ownerUserId"), ownerUserId);
    Predicate firstNameLike = builder.like(root.get("firstName"), searchQuery);
    Predicate middleNameLike = builder.like(root.get("middleName"), searchQuery);
    Predicate lastNameLike = builder.like(root.get("lastName"), searchQuery);

    query
        .select(root)
        .where(builder.and(hasOwnerId, builder.or(firstNameLike, middleNameLike, lastNameLike)));
    TypedQuery<Student> typedQuery = em.createQuery(query);
    typedQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
    typedQuery.setMaxResults(pageable.getPageSize());

    // TODO: lazy fetch?
    return new PageImpl<>(typedQuery.getResultList(), pageable, count);
  }
}
