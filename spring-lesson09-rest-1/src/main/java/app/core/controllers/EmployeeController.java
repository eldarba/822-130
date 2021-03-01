package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.entities.Employee;
import app.core.services.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/greet")
	public String greet() {
		return "Hello from the web service";
	}

	@RequestMapping(path = "/employees2", method = { RequestMethod.GET, RequestMethod.POST }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Employee> getAllEmps2() {
		return service.getAllEmps();
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmps() {
		return service.getAllEmps();
	}

//	@GetMapping("/employees/{id}")
//	public Employee getOneEmp(@PathVariable(name = "id") int empId) {
//		return service.getEmployee(empId);
//	}

	// http://localhost:8080/api/employees/one/1
	@GetMapping("/employees/one/{id}")
	public Employee getOneEmp(@PathVariable int id) {
		try {
			return service.getEmployee(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	// http://localhost:8080/api/employees/one?id=1
	@GetMapping("/employees/one")
	public ResponseEntity<?> getOneEmp2(@RequestParam int id) {
		try {
			Employee emp = service.getEmployee(id);
			return ResponseEntity.ok(emp);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
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

//	@PostMapping("/employees/{name}/{role}")
//	public Employee addEmployee(@PathVariable String name, @PathVariable String role) {
//		Employee emp = new Employee(0, name, role);
//		try {
//			return service.addEmployee(emp);
//		} catch (Exception e) {
//			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
//		}
//	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		try {
			return service.updateEmp(employee);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "updateEmployee failed: " + e.getMessage());
		}
	}

}
