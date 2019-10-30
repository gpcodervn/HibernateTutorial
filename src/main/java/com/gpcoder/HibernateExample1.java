package com.gpcoder;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.gpcoder.entities.User;
import com.gpcoder.utils.HibernateUtils;

public class HibernateExample1 {
	
	public static void main(String[] args) {
		
		try (Session session = HibernateUtils.getSessionFactory().openSession();) {
			// Begin a unit of work
			session.beginTransaction();

			// Insert user
			Date currentDate = new Date();
			User user1 = new User();
			user1.setFullname("Hibernate Example");
			user1.setUsername("gpcoder");
			user1.setPassword("123456"); // Should encode password
			user1.setCreatedAt(currentDate);
			user1.setModifiedAt(currentDate);
			Long userId = (Long) session.save(user1);
			System.out.println("User id = " + userId); 
			
			// Count user from database
			Long numberOfUser = session.createQuery("SELECT COUNT(id) FROM User", Long.class).uniqueResult();
			System.out.println("Number of user in database: " + numberOfUser);
			
			// Get user by id
			User savedUser = session.find(User.class, userId);
			System.out.println("savedUser: " + savedUser);
			
			// Update user
			savedUser.setFullname("GP Coder");
			session.update(savedUser);

			// Get users
			List<User> users = session.createQuery("FROM User", User.class).list();
			users.forEach(System.out::println);
			
			// Delete user
			session.delete(savedUser);
			
			// Count user from database
			numberOfUser = session.createQuery("SELECT COUNT(id) FROM User", Long.class).uniqueResult();
			System.out.println("Number of user in database: " + numberOfUser);
			
			// Commit the current resource transaction, writing any unflushed changes to the database.
			session.getTransaction().commit();
		}
	}
}
