package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.core.entities.Classroom;
import app.core.entities.Student;
import app.core.services.SchoolService;

@RestController
@RequestMapping("/api")
public class SchoolController {

	private SchoolService schoolService;

	@Autowired
	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}

	@PostMapping("/add/student")
	public Student addStudent(@RequestBody Student student) {
		return schoolService.addStudent(student);
	}

	@PostMapping("/add/classroom")
	public Classroom addSClass(@RequestBody Classroom classroom) {
		return schoolService.addClassroom(classroom);
	}
}
