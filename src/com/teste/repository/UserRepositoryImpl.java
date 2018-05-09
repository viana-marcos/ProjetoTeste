package com.teste.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.teste.model.User;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository{
	
	@PersistenceContext
	public EntityManager entityManager;
	
	public List<User> findAll(){
		 CriteriaQuery<User> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(User.class);
	     @SuppressWarnings("unused")
	     Root<User> root = criteriaQuery.from(User.class);
	     return this.entityManager.createQuery(criteriaQuery).getResultList();
	}

}
