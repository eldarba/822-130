package app.core;

import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import app.core.models.Employee;

public class App6All {

	private RestTemplate restTemplate = new RestTemplate();
	private String url;

	public static void main(String[] args) {

		try {
			App6All app = new App6All();

//			{// get one
//				Employee emp = app.doGetOne(2);
//				System.out.println(emp);
//			}

			{ // get all
				List<Employee> emps = app.doGetAll();
				for (Employee employee : emps) {
					System.out.println(employee);
				}
			}

//			{
//				Employee e = app.doDeleteOne(2);
//				System.out.println(e + " deleted");
//			}

		} catch (Exception e) {
			System.out.println("Error");
			System.out.println(e);
		}

	}

	public List<Employee> doGetAll() {
		url = "http://localhost:8080/api/employees/wrapped";
		EmployeeListWrapper wrapper = restTemplate.getForObject(url, EmployeeListWrapper.class);
		return wrapper.getEmps();
	}

	public Employee doGetOne(int id) {
		url = "http://localhost:8080/api/employees/one?id={id}";
		Employee e = restTemplate.getForObject(url, Employee.class, id);
		return e;
	}

	public Employee doDeleteOne(int id) {
		url = "http://localhost:8080/api/employees?id={id}";
		ResponseEntity<Employee> re = restTemplate.exchange(url, HttpMethod.DELETE, null, Employee.class, id);
		Employee e = re.getBody();
		return e;
	}

}
