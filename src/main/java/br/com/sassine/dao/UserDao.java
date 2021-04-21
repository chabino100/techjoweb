package br.com.sassine.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.sassine.entity.User;
import br.com.sassine.factory.EntityManagerFacade;

public class UserDao {

	EntityManager manager = EntityManagerFacade.getEntityManager();

	public void create(User user) {
		
		manager.getTransaction().begin();
		manager.persist(user);
		manager.getTransaction().commit();
		
		manager.close();
	
	}

	public List<User> getAll() {
		String jpql = "SELECT s FROM User s";
		TypedQuery<User> query = manager.createQuery(jpql, User.class);
		return query.getResultList();
	}

}
