package com.eobrazovanje.ssluzba.entityManager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import org.springframework.stereotype.Component;

import com.eobrazovanje.ssluzba.entities.Subject;

@Component
public class UtilManager {

	

	
	public List<Subject> queryForSubjectsForSpecificStudent(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HypersistenceOptimizer");
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Subject> subjects = (List<Subject>) em.createQuery(
				"SELECT s from Subject s").getResultList();
		return subjects;		
		
	}
	

}
