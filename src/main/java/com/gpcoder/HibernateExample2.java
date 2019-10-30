package com.gpcoder;

import org.hibernate.Session;

import com.gpcoder.entities.Category;
import com.gpcoder.utils.HibernateUtils;

public class HibernateExample2 {

public static void main(String[] args) {
		
		try (Session session = HibernateUtils.getSessionFactory().openSession();) {
			// Begin a unit of work
			session.beginTransaction();

			// Insert user
			Category cat = new Category();
			cat.setName("cat " + System.currentTimeMillis());
			System.out.println("Cat id = " + session.save(cat));
			
			// Commit the current resource transaction, writing any unflushed changes to the database.
			session.getTransaction().commit();
		}
	}
}
