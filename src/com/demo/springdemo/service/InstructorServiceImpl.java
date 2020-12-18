package com.demo.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.springdemo.dao.InstructorDAO;
import com.demo.springdemo.entity.Instructor;

@Service
public class InstructorServiceImpl implements InstructorService {

	// need to inject customer dao
	@Autowired
	private InstructorDAO instructorDAO;
	
	@Override
	@Transactional
	public List<Instructor> getInstructors() {
		return instructorDAO.getInstructors();
	}

	@Override
	@Transactional
	public void saveInstructor(Instructor theInstructor) {
		instructorDAO.saveInstructor(theInstructor);
		
	}

	@Override
	@Transactional
	public Instructor getInstructor(int theId) {
		return instructorDAO.getInstructor(theId);
	}

	@Override
	@Transactional
	public void deleteInstructor(int theId) {
		instructorDAO.deleteInstructor(theId);
		
	}
}





