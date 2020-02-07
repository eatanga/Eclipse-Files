package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CarList;



public class CarListHelper {
	static EntityManagerFactory emfactory =
			Persistence.createEntityManagerFactory("CarInventory ");
	public void
	insertItem(CarList cl) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(cl);
		em.getTransaction().commit();
		em.close();
	}
	public void deleteCar(CarList toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CarList> typedQuery = em.createQuery("select li from ListItem li where li.store = :selectedStore and li.item = :selectedItem", CarList.class);
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedStore", toDelete.getCompany());
		typedQuery.setParameter("selectedItem", toDelete.getCar());
		//we only want one result
		typedQuery.setMaxResults(1);
		//get the result and save it into a new list item
		CarList result = typedQuery.getSingleResult();
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}
	public void addNewCar(CarList cl) {
		EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(cl);
			em.getTransaction().commit();
			em.close();
			}
	public List<CarList> viewInventory(){
		EntityManager em = emfactory.createEntityManager();
		List<CarList> allItems = em.createQuery("SELECT i FROM ListItem i").getResultList();
		return allItems;
		}
	
	public void clearUp(){
		emfactory.close();
		}
	public List<CarList> showInventory(){
		EntityManager em = emfactory.createEntityManager();
		List<CarList> inventory = em.createQuery("SELECT i FROM ListItem i").getResultList();
		return inventory;
		}
}
