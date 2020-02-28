package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.PurchaseDetails;

public class PurchaseDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CarInventoryList");

	public void insertNewPurchaseDetails(PurchaseDetails p) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<PurchaseDetails> getInventory() {
		EntityManager em = emfactory.createEntityManager();
		List<PurchaseDetails> allDetails = em.createQuery("SELECT d FROM PurchaseDetails d").getResultList();
		return allDetails;
	}

	public PurchaseDetails searchForInventoryById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		PurchaseDetails found = em.find(PurchaseDetails.class, tempId);
		em.close();
		return found;
	}

	public void deleteInventory(PurchaseDetails inventoryToDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PurchaseDetails> typedQuery = em.createQuery("select d from PurchaseDetails d where d.id = :selectedid",PurchaseDetails.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedid", inventoryToDelete.getId());
		

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list detail object
		PurchaseDetails result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}

	public void updateInventory(PurchaseDetails toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

}



