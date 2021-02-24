package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.core.entities.Employee;
import app.core.services.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/emps")
	public Employee addEmployee(@RequestBody Employee employee) {
		return service.addEmployee(employee);
	}

	@GetMapping(path = "/emps", consumes = MediaType.APPLICATION_JSON_VALUE, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<Employee> getAllEmployees() {
		return service.getAll();
	}

}
