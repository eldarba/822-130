package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.entities.Employee;
import app.core.services.EmployeeService;
import app.core.sessions.Session;
import app.core.sessions.SessionContext;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	@Autowired
	private SessionContext sessionContext;

	// the calling client will supply their token in the request header
	@GetMapping("/greet")
	public String greet(@RequestHeader String token) {
		Session session = sessionContext.getSession(token);
		if (session != null) {
			return "Hello " + session.getAttribute("userName");
		}
		return "Hello not logged user";
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmps() {
		return service.getAllEmps();
	}

	// http://localhost:8080/api/employees/one/1
	@GetMapping("/employees/one/{id}")
	public Employee getOneEmp(@PathVariable int id) {
		try {
			return service.getEmployee(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	// add a controller end point for adding a new employee to the system. and test
	// it.
	@PostMapping(path = "/employees", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Employee addEmployee(@RequestBody Employee employee) {
		try {
			return service.addEmployee(employee);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
		}
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		try {
			return service.updateEmp(employee);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "updateEmployee failed: " + e.getMessage());
		}
	}

	@DeleteMapping("/employees")
	public Employee deleteEmp(@RequestParam int id) {
		try {
			return service.deleteEmp(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

}
