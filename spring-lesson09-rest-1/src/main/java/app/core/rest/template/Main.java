package app.core.rest.template;

import java.net.URI;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;

import app.core.entities.Employee;

public class Main {

	public static void main(String[] args) {

		try {
			RestTemplate rt = new RestTemplate();
			String url = null;

//			{// GET
//				// set the url
//				url = "http://localhost:8080/api/person/find-one/1";
//				// set the request and get a response
//				ResponseEntity<Employee> responseEntity = rt.exchange(url, HttpMethod.GET, null, Employee.class);
//				System.out.println(responseEntity);
//				Employee emp = responseEntity.getBody();
//				System.out.println(emp);
//			}

			{// GET all employees
//				url = "http://localhost:8080/api/person/find-all";
//				ParameterizedTypeReference<List<Employee>> type = new ParameterizedTypeReference<List<Employee>>() {
//				};
//				ResponseEntity<List<Employee>> re = rt.exchange(url, HttpMethod.GET, null, type);
//				List<Employee> list = re.getBody();
//				System.out.println(list);

			}

			{ // POST
//				url = "http://localhost:8080/api/person/add";
//				Employee e = new Employee(0, "Moshe", "Engineer");
//				// send the request using postForObject
//				e = rt.postForObject(new URI(url), e, Employee.class);
//				System.out.println(e);

			}

			{ // PUT
				url = "http://localhost:8080/api/person/update";
				Employee employee = new Employee(1, "Sarrah", "Engineer");
				// send the request using postForObject
				RequestEntity<Employee> request = new RequestEntity<Employee>(employee, HttpMethod.PUT, new URI(url));
				employee = rt.exchange(request, Employee.class).getBody();
				System.out.println(employee);
				url = "http://localhost:8080/api/person/update";
			}

			{// DELETE
				int id = 2;
				url = "http://localhost:8080/api/person/delete?id=" + id;
				rt.delete(url);

			}

		} catch (Exception e) {
			System.err.println("================");
			System.err.println(e.getMessage());
		}

	}

}
