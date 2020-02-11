package com.uniovi.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.uniovi.entities.Teacher;

@Service
public class TeacherService {
	
	private List<Teacher> teachers = new ArrayList<Teacher>();
	
	@PostConstruct
	public void init() {
		teachers.add(new Teacher(1L,"123456N","Juan","Garcia Rodriguez","Matematicas"));
		teachers.add(new Teacher(2L,"123457L","Diego","Santos Neila","Informatica"));
	}
	
	public List<Teacher> getTeachers(){
		return teachers;
	}
	
	public Teacher getTeacher(Long id) {
		return teachers.stream().filter(teacher -> teacher.getId().equals(id)).
				findFirst().get();	
	}
	
	public void addTeacher(Teacher teacher) {
		if(teacher.getId()== null) {
			teacher.setId(teachers.get(teachers.size() - 1).getId() + 1);
		}else {
			teachers.removeIf(t -> t.getId().equals(t.getId()));
		}
		
		teachers.add(teacher);
	}
	
	public void deleteTeacher(Long id) {
		teachers.removeIf(teacher -> teacher.getId().equals(id));
	}
}
