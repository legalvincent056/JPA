package dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Query;

import metier.Adresse;
import metier.Contact;
import metier.Film;

public class Dao implements IDao {
	
	
	//1- Ouverture de l'unité de persistance
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
	

	@Override
	public int ajouterAdresse(Adresse a) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(a);
		
		tx.commit();
		em.close();
		return a.getId();
	}

	@Override
	public int ajouterContactAdresse(Contact c, Adresse a) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		c.setAdresse(a);
		em.persist(c);
		
		tx.commit();
		em.close();
	
		return a.getId();
	}

	@Override
	public int modifierAdresse(Adresse a) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.merge(a);
		
		tx.commit();
		em.close();
		
		return a.getId();
	}

	@Override
	public Collection<Contact> findAllContacts() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		List<Contact> lc = em.createQuery("SELECT c FROM Contact c").getResultList();
	
		tx.commit();
		em.close();
			return lc;
	}

	@Override
	public Adresse findAdresse(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Adresse a= (Adresse) em.createQuery("SELECT a FROM Adresse a WHERE a.id= :"+id).getSingleResult();
		
		tx.commit();
		em.close();
		return a;
	}

	@Override
	public void deleteAdresse(Adresse a) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.remove(a);
		
		tx.commit();
		em.close();
	}

}
