package controller;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CarList;



public class CarListHelper {
	static EntityManagerFactory emfactory =
			Persistence.createEntityManagerFactory("CarInventoryList");
	public void addCar(CarList cl) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(cl);
		em.getTransaction().commit();
		em.close();
	}
	public void deleteCar(CarList toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CarList> typedQuery = em.createQuery("select cl from CarList cl where cl.company = :selectedCompany and cl.car = :selectedCar", CarList.class);
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedCompany", toDelete.getCompany());
		typedQuery.setParameter("selectedCar", toDelete.getCar());
		//Only One result is needed
		typedQuery.setMaxResults(1);
		//save new result to New Car list after getting it
		CarList result = typedQuery.getSingleResult();
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}
	
	public void updateCar(CarList toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public CarList searchForCarById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CarList found = em.find(CarList.class, idToEdit);
		em.close();
		return found;
	}
	public List<CarList> searchForCarByCompany(String companyName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CarList> typedQuery = em.createQuery("select cl from CarList cl where cl.company = :selectedCompany", CarList.class);
		typedQuery.setParameter("selectedCompany", companyName);
		List<CarList> foundCar = typedQuery.getResultList();
		em.close();
		return foundCar;
		}
	
	public List<CarList> searchForCarByCar(String carName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CarList> typedQuery = em.createQuery("select cl from CarList cl where cl.car = :selectedCar", CarList.class);
		typedQuery.setParameter("selectedCar", carName);
		List<CarList> foundCar = typedQuery.getResultList();
		em.close();
		return foundCar;
		}


	

	public List<CarList> viewInventory(){
		EntityManager em = emfactory.createEntityManager();
		List<CarList> allCars = em.createQuery("SELECT i FROM CarList i").getResultList();
		return allCars;
		}
	
	
	public void clearUp(){
		emfactory.close();
		}
	
}
