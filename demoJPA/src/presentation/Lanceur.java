package presentation;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import metier.Adresse;
import metier.Contact;
import metier.CourtMetrage;
import metier.Film;
import metier.LongMetrage;
import metier.TeleFilm;

public class Lanceur {

	public static void main(String[] args) {
		// 1- Ouverture de l'unité de persistance
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu"); //création d'un entityManageFactory
		EntityManager em = emf.createEntityManager(); //création d'un entitymanager
				
		//2- Ouverture de la transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		
		//3- Création d'un objet métier
		
		Adresse s = new Adresse();
		s.setVille("Lyon");
		s.setCodePostale("69006");
		s.setNomRue("rue du chat qui tousse");
		
		
		Contact c = new Contact();
		c.setNom("Jojo");
		c.setPrenom("lulu");
		c.setEmail("lulu.jojo@hotmail.gr");
		
		c.setAdresse(s); //assignation de l'adresse à la personne
		
		//Création d'un long métrage
		LongMetrage lm = new LongMetrage();
		lm.setNomFilm("Les dents de ta mère");
		lm.setCinema("GAUMONT");
	
		//Création d'un téléfilm
		
		TeleFilm tf = new TeleFilm();
		tf.setChaine("TF1");
		tf.setNomFilm("Camping paradis");

		
		
		//4- Persistance de l'objet métier
		em.persist(c);
		em.persist(lm);
		em.persist(tf);
		
		//5- Valisation de la transaction
		tx.commit();
		
		//6- Fermeture de l'unité de persistance
		em.close();
		emf.close();
	}

}
