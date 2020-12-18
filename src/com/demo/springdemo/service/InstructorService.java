package com.demo.springdemo.service;

import java.util.List;

import com.demo.springdemo.entity.Instructor;

public interface InstructorService {

	public List<Instructor> getInstructors();

	public void saveInstructor(Instructor theInstructor);

	public Instructor getInstructor(int theId);

	public void deleteInstructor(int theId);
	
}
