package com.demo.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.springdemo.entity.Instructor;

@Repository
public class InstructorDAOImpl implements InstructorDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Instructor> getInstructors() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query
		Query<Instructor> theQuery = 
				currentSession.createQuery("from Instructor order by lastName", Instructor.class);
		
		// execute query and get result list
		List<Instructor> instructors = theQuery.getResultList();
				
		// return the results		
		return instructors;
	}

	@Override
	public void saveInstructor(Instructor theInstructor) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theInstructor);
	}

	@Override
	public Instructor getInstructor(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Instructor theInstructor = currentSession.get(Instructor.class,theId);
		return theInstructor;
	}

	@Override
	public void deleteInstructor(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Instructor where id = :instructorId");
				theQuery.setParameter("instructorId", theId);
				theQuery.executeUpdate();
		
	}

}






