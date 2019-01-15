package com.zuehlke.testing.rules;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

public class PersonDao {
	private static EntityManagerFactory emf;
	private static EntityManager em;

	public PersonDao() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("rules");
			em = emf.createEntityManager();
		}
	}

	public void save(Person person) {
		em.getTransaction().begin();
		em.persist(person);
		em.getTransaction().commit();
	}

	public void delete(Person person) {
		em.getTransaction().begin();
		em.remove(person);
		em.getTransaction().commit();
	}

	public Person find(String name) {
		CriteriaBuilder criteriaBuilder = emf.getCriteriaBuilder();
		CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
		Root<Person> root = criteriaQuery.from(Person.class);
		ParameterExpression<String> parameter = criteriaBuilder.parameter(String.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("name"), parameter));

		TypedQuery<Person> query = em.createQuery(criteriaQuery);
		query.setParameter(parameter, name);

		return query.getSingleResult();
	}

	public Person longLastingQuery(String name) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// Nothing to do
		}
		return find(name);
	}
}
