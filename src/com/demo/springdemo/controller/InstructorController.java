package com.demo.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.springdemo.dao.InstructorDAO;
import com.demo.springdemo.entity.Instructor;
import com.demo.springdemo.service.InstructorService;

@Controller
@RequestMapping("/instructor")
public class InstructorController {

	// need to inject the customer dao
	@Autowired
	private InstructorService instructorService;
	
	@GetMapping("/list")
	public String listInstructors(Model theModel) {
		
		// get customers from the service
		List<Instructor> theInstructors = instructorService.getInstructors();
				
		// add the customers to the model
		theModel.addAttribute("instructors", theInstructors);
		
		return "list-instructors";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Instructor theInstructor = new Instructor();
		theModel.addAttribute("instructor",theInstructor);
		return "instructor-form";
	}
	
	@PostMapping("/saveInstructor")
	public String saveInstructor(@ModelAttribute("instructor") Instructor theInstructor)
	{
		instructorService.saveInstructor(theInstructor);
		return "redirect:/instructor/list";
	}
	

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("instructorId") int theId , Model theModel) {
		
		Instructor theInstructor = instructorService.getInstructor(theId);
		theModel.addAttribute("instructor",theInstructor);
		return "instructor-form";
	}
	
	@GetMapping("/delete")
	public String deleteInstructor(@RequestParam("instructorId") int theId) {
		
	instructorService.deleteInstructor(theId);
	return "redirect:/instructor/list";
		
	}
}


