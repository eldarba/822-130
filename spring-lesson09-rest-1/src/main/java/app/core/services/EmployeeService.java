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

	public Employee addEmployee(Employee emp) {
		return repo.save(emp);
	}

	public Employee getEmployee(int empId) {
		Optional<Employee> opt = repo.findById(empId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

	public List<Employee> getAllEmps() {
		return repo.findAll();
	}

	public Employee updateEmp(Employee emp) {
		Employee empFromDb = getEmployee(emp.getId());
		if (empFromDb != null) {
			empFromDb.setName(emp.getName());
			empFromDb.setRole(emp.getRole());
		}
		return empFromDb;
	}

	public void deleteEmp(int empId) {
		repo.deleteById(empId);
	}

}
