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

    CriteriaQuery<Student> query = builder.createQuery(Student.class);
    Root<Student> entityRoot = query.from(Student.class);
    entityRoot.alias("root");

    Predicate hasOwnerId = builder.equal(entityRoot.get("ownerUserId"), ownerUserId);
    Predicate firstNameLike = builder.like(entityRoot.get("firstName"), searchQuery);
    Predicate middleNameLike = builder.like(entityRoot.get("middleName"), searchQuery);
    Predicate lastNameLike = builder.like(entityRoot.get("lastName"), searchQuery);

    query.select(entityRoot).where(builder.and(hasOwnerId, builder.or(firstNameLike, middleNameLike, lastNameLike)));
    TypedQuery<Student> typedQuery = em.createQuery(query);
    typedQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
    typedQuery.setMaxResults(pageable.getPageSize());

    CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
    Root<Student> countRoot = countQuery.from(Student.class);
    countRoot.alias("root");
    Predicate hasOwnerIdCount = builder.equal(countRoot.get("ownerUserId"), ownerUserId);
    Predicate firstNameLikeCount = builder.like(countRoot.get("firstName"), searchQuery);
    Predicate middleNameLikeCount = builder.like(countRoot.get("middleName"), searchQuery);
    Predicate lastNameLikeCount = builder.like(countRoot.get("lastName"), searchQuery);
    countQuery.select(builder.count(countRoot)).where(builder.and(hasOwnerIdCount, builder.or(firstNameLikeCount, middleNameLikeCount, lastNameLikeCount)));
    Long count = em.createQuery(countQuery).getSingleResult();
    // TODO: lazy fetch?
    return new PageImpl<>(typedQuery.getResultList(), pageable, count);
  }
}
