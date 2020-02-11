package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uniovi.entities.Teacher;
import com.uniovi.services.TeacherService;

@Controller
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping("/teacher/list")
	public String getList(Model model) {
		model.addAttribute("teacherList", teacherService.getTeachers());
		
		return "teacher/list";
	}	
	@RequestMapping("/teacher/add")
	public String getTeacher() {
		return "teacher/add";
	}
	
	@RequestMapping(value="/teacher/details/{id}")
	public String getDetail(Model model, @PathVariable Long id) {
		model.addAttribute("teacher", teacherService.getTeacher(id));
		return "teacher/details";
	}
	
	@RequestMapping(value="/teacher/delete/{id}")
	public String deteleTeacher(@PathVariable Long id) {
		teacherService.deleteTeacher(id);
		return "redirect:/teacher/list";
	}
	@RequestMapping(value="/teacher/add", method=RequestMethod.POST)
	public String setTeacher(@ModelAttribute Teacher teacher) {
		teacherService.addTeacher(teacher);
		return "redirect:/teacher/list";
	}
	@RequestMapping(value="teacher/edit/{id}")
	public String getEdit(Model model,@PathVariable Long id) {
		model.addAttribute("teacher", teacherService.getTeacher(id));
		return "teacher/edit";
	}
	
	@RequestMapping(value="/teacher/edit/{id}", method=RequestMethod.POST)
	public String setEdit(@ModelAttribute Teacher teacher, @PathVariable Long id) {
		teacher.setId(id);
		teacherService.addTeacher(teacher);
		return "redirect:/teacher/details/" + id;
	}
}
