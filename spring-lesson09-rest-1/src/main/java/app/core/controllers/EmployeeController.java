package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.entities.Employee;
import app.core.services.EmployeeService;

@RestController
@RequestMapping("/api/person")
public class EmployeeController {

	@Autowired
	private EmployeeService empServcie;

	@GetMapping("/greet")
	public String greet() {
		return "Hello from new controller";
	}

	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		try {
			return empServcie.addEmployee(employee);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	// id is given on path [/]
	@GetMapping("/find-one/{id}")
	public Employee findOne1(@PathVariable int id) {
		try {
			return empServcie.getEmployee(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	// id is given as parameter [?]
	@GetMapping("/find-one")
	public Employee findOne2(@RequestParam int id) {
		try {
			return empServcie.getEmployee(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping("/find-all")
	public List<Employee> findAll() {
		return empServcie.getAllEmps();
	}

	@PutMapping("/update")
	public Employee update(@RequestBody Employee employee) {
		try {
			return empServcie.updateEmp(employee);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@DeleteMapping("/delete")
	public void delete(@RequestParam int id) {
		empServcie.deleteEmp(id);
	}

}
