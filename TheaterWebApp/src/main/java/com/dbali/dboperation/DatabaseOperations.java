package com.dbali.dboperation;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dbali.bean.PlaySearchBean;
import com.dbali.entity.Customer;
import com.dbali.entity.Play;


public class DatabaseOperations {

	private static final String PERSISTENCE_UNIT_NAME = "TheaterPU";	
	private static EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	private static EntityTransaction transactionObj = entityMgrObj.getTransaction();

	 private List<Play> play;
	 
		/*
		 * public void Serach() { EntityManagerFactory emf
		 * =Persistence.createEntityManagerFactory("TheaterPU"); entityMgrObj =
		 * emf.createEntityManager(); play =
		 * entityMgrObj.createNamedQuery("Plays.findAll").getResultList(); }
		 */
	
	 @SuppressWarnings("unchecked")
		public static List<PlaySearchBean> getAllSchoolDetails() {
			Query queryObj = entityMgrObj.createQuery("Show.findByStartDate");
			List<PlaySearchBean> playList = queryObj.getResultList();
			if (playList != null && playList.size() > 0) {			
				return playList;
			} else {
				return null;
			}
		}
	 
	 
	 public static boolean ExistUsername(String username) {
			boolean Exist = false;
			Query queryObj = entityMgrObj.createQuery("SELECT s FROM Customer s WHERE s.username = :username");
			queryObj.setParameter("username", username);
			Customer objCustomer = (Customer) queryObj.getSingleResult();
			
			if(objCustomer != null) {
				Exist = true;
			}
			return Exist;
		}
	 
	 
	 
	 
		public static boolean createNewConsumer(String name, String lname,String Birthday, String Email,String Gender,String Username, String Passw,int usertype) {
			if(!transactionObj.isActive()) {
				transactionObj.begin();
			}

			Customer newCustomerObj = new Customer();
		 
			newCustomerObj.setFirstname(name);
			newCustomerObj.setSecondname(lname);
			newCustomerObj.setDateofbirth(Birthday);
			newCustomerObj.setEmail(Email);
			newCustomerObj.setGender(Gender);
			newCustomerObj.setUsername(Username);
			newCustomerObj.setPassword(Passw);
			newCustomerObj.setUserType(usertype);
			//newCustomerObj.setUserType();
			
		
			
			entityMgrObj.persist(newCustomerObj);
			transactionObj.commit();
			return true;
		}

}
