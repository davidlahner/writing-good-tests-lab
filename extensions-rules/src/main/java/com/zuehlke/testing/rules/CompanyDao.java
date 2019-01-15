package com.zuehlke.testing.rules;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

public class CompanyDao {
	private static EntityManagerFactory emf;
	private static EntityManager em;

	public CompanyDao() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("rules");
			em = emf.createEntityManager();
		}
	}

	public void save(Company company) {
		em.getTransaction().begin();
		em.persist(company);
		em.getTransaction().commit();
	}

	public void delete(Company company) {
		em.getTransaction().begin();
		em.remove(company);
		em.getTransaction().commit();
	}

	public Company find(String name) {
		CriteriaBuilder criteriaBuilder = emf.getCriteriaBuilder();
		CriteriaQuery<Company> criteriaQuery = criteriaBuilder.createQuery(Company.class);
		Root<Company> root = criteriaQuery.from(Company.class);
		ParameterExpression<String> parameter = criteriaBuilder.parameter(String.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("name"), parameter));

		TypedQuery<Company> query = em.createQuery(criteriaQuery);
		query.setParameter(parameter, name);

		return query.getSingleResult();
	}

	public Company longLastingQuery(String name) {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// Nothing to do
		}
		return find(name);
	}
}
