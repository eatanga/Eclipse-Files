package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Buyer;

public class BuyerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CarInventoryList");

	public void insertBuyer(Buyer b) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
	}

	public List<Buyer> showAllBuyers() {
		EntityManager em = emfactory.createEntityManager();
		List<Buyer> allBuyers = em.createQuery("SELECT b FROM Buyer b").getResultList();
		return allBuyers;
	}

	public Buyer searchForBuyerByName(String buyerName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Buyer> typedQuery = em.createQuery("select b from Buyer b where b.buyerName = :selectedName", Buyer.class);
		typedQuery.setParameter("selectedName", buyerName);
		typedQuery.setMaxResults(1);

		Buyer found = typedQuery.getSingleResult();
		em.close();
		return found;
	}
}



