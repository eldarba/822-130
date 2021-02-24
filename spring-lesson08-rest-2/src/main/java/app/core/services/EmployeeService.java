package app.core.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.Employee;
import app.core.repositories.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	public Employee addEmployee(Employee employee) {
		return repo.save(employee);
	}

	public Employee getEmployee(int id) {
		Optional<Employee> opt = repo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

	public List<Employee> getAll() {
		return repo.findAll();
	}

	// add the following methods and use them in the controller
	// update existing employee
	// delete employee by id
	// delete all employees

	// add more entities (relations) add services
	// expose them through controllers

}
