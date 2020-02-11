package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.Teacher;
import com.uniovi.services.TeacherService;

@RestController
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping(value="/teacher/details/{id}")
	public String getDetail(@PathVariable Long id) {
		return teacherService.getTeacher(id).toString();
	}
	
	@RequestMapping(value="/teacher/delete/{id}")
	public String deteleTeacher(@PathVariable Long id) {
		teacherService.deleteTeacher(id);
		return "DELETED";
	}
	@RequestMapping(value="/teacher/add", method=RequestMethod.POST)
	public String addTeacher(@ModelAttribute Teacher teacher) {
		teacherService.addTeacher(teacher);
		return "TEACHER ADDED";
	}
	
	@RequestMapping(value="/teacher/edit", method=RequestMethod.POST)
	public String setEdit(@ModelAttribute Teacher teacher) {
		teacher.setId(teacher.getId());
		teacherService.addTeacher(teacher);
		return "TEACHER EDITED";
	}
}
